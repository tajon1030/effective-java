package org.example.chapter2.Item17;

import java.util.ArrayList;
import java.util.List;

public class MutableClassTest {
    public static void main(String[] args) {
        // 객체의 상태를 변경하는 메서드를 제공하면, 클래스를 불변으로 만들 수 없음
        MutableClass mutableClass = new MutableClass("값1");
        System.out.println(mutableClass.getName());
        mutableClass.setName("값2");
        System.out.println(mutableClass.getName());

        // 상속을 하면 불변성이 께질 수 있음
        ParentClass parentClass = new ParentClass("상속받은 클래스");
        List<Integer> list = parentClass.getList();
        list.add(1);
        list = parentClass.getList();
        for(int i : list){
            System.out.println(i);
        }

        // 아래와 같이 필드에 직접 접근
        UnStableImmutableClass unStableImmutableClass = new UnStableImmutableClass("값4");
        System.out.println(unStableImmutableClass.name);

        List<CanModify> modifies = new ArrayList<>();
        Person person = new Person("1", modifies);
//
//        modifies.add(new CanModify("2"));
//        System.out.println(person.canModifies().size());  // 0
//        modifies.add(new CanModify("3"));
//        System.out.println(person.canModifies().size());  // 0

        StablePerson stablePerson = new StablePerson("1", modifies);
        System.out.println(person.canModifies().size());  // 0

        modifies.add(new CanModify("2"));
        System.out.println(stablePerson.canModifies().size());  // 0
        modifies.add(new CanModify("3"));
        System.out.println(stablePerson.canModifies().size());  // 0
        //Person 내부의 값이 바뀜

        //List 자체를 변경하는 것은 불가능하지만, List 내부에 존재하는 객체들에 대한 참조는 공유될 수 있기때문

//        List<CanModify> modifies2 = List.of(new CanModify("수정가능 1"), new CanModify("수정가능 2"));
//        StablePerson stablePerson1 = new StablePerson("a", modifies2);
//
//        System.out.println(stablePerson1.canModifies().get(0).name());
//        System.out.println(stablePerson1.canModifies().get(1).name());
//
//        modifies2.get(0).setName("수정 > 3");
//        stablePerson1.canModifies().get(1).setName("수정 > 4");
//
//        System.out.println(stablePerson1.canModifies().get(0).name());
//        System.out.println(stablePerson1.canModifies().get(1).name());

        List<StableCanModify> modifies2 = List.of(new StableCanModify("수정가능 1"), new StableCanModify("수정가능 2"));
        RealStablePerson stablePerson1 = new RealStablePerson("a", modifies2);

        System.out.println(stablePerson1.canModifies().get(0).name());
        System.out.println(stablePerson1.canModifies().get(1).name());

        modifies2.get(0).setName("수정 > 3");
        stablePerson1.canModifies().get(1).setName("수정 > 4");

        System.out.println(stablePerson1.canModifies().get(0).name());
        System.out.println(stablePerson1.canModifies().get(1).name());

    }
}
