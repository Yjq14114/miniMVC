package com.miniMVC.chapter3.collect;

import com.miniMVC.chapter3.bean.Person;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.impl.factory.Lists;

import java.util.List;

/**
 * Created by yjq14 on 2018/6/29.
 */
public class CollectNoBun {
    public static void main(String[] args) {
        ImmutableList<Person> of = Lists.immutable.of(new Person("Alice", 19), new Person("Michael", 21), new Person("jerry", 18));
        ImmutableList<String> collect = of.select(person -> person.getAge() < 20).collect(Person::getName);
        collect.forEach(System.out::println);
    }
}
