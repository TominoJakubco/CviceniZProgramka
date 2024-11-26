package org.delta.observer.example;

import org.delta.observer.Observer;

public class TestObservers {

    public static void main(String []a) {

        //observer test
        MyTopic topic = new MyTopic();

        Observer myTopicSubscriber1 = new MyTopicSubscriber("Obj1");
        Observer myTopicSubscriber2 = new MyTopicSubscriber("Obj2");
        Observer myTopicSubscriber3 = new MyTopicSubscriber("Obj3");

        topic.register(myTopicSubscriber1);
        topic.register(myTopicSubscriber2);
        topic.register(myTopicSubscriber3);

        //check if any update is available
        myTopicSubscriber1.update();

        //now send message to subject
        topic.postMessage("New message");
    }
}
