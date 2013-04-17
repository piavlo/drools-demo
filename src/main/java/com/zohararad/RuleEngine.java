package com.zohararad;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseConfiguration;
import org.drools.KnowledgeBaseFactory;
import org.drools.conf.EventProcessingOption;
import org.drools.runtime.rule.WorkingMemoryEntryPoint;
import org.drools.builder.*;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import java.util.Random;

public class RuleEngine {

  private static WorkingMemoryEntryPoint entryPointProductEventsStream;

  public static void main(String[] args) throws Exception{
    KnowledgeBase kbase = readKnowledgeBase();
    StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
    entryPointProductEventsStream = ksession.getWorkingMemoryEntryPoint("EventsStream");
    int x = 0;
    Random randomGenerator = new Random();
    while(true){
      String event;
      if(x % 2 == 0){
        event = "view";
      } else {
        event = "conversion";
      }
      int id = randomGenerator.nextInt(3);
      GenericEvent ev = new GenericEvent(event, id);
      //System.out.println(ev.getEvent());
      entryPointProductEventsStream.insert(ev);
      ksession.fireAllRules();
      int randomInt = randomGenerator.nextInt(1000);
      Thread.sleep(randomInt);
      x++;
    }
  }

  private static KnowledgeBase readKnowledgeBase() throws Exception {
    KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
    kbuilder.add(ResourceFactory.newClassPathResource("rules.drl"), ResourceType.DRL);
    KnowledgeBuilderErrors errors = kbuilder.getErrors();
    if (errors.size() > 0) {
      for (KnowledgeBuilderError error: errors) {
        System.err.println(error);
      }
      throw new IllegalArgumentException("Could not parse knowledge.");
    }
    KnowledgeBaseConfiguration config = KnowledgeBaseFactory.newKnowledgeBaseConfiguration();
    config.setOption(EventProcessingOption.STREAM);

    KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase(config);
    kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
    return kbase;
  }
}
