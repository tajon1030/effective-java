package org.example.chapter1.item1.exam;

public class SingerFactory {
    // 객체 생성 위임 - 정적 팩토리 메서드 방식으로 OCP 충족
    // 개방 폐쇄 원칙(OCP, Open Closed Principle) 확장에 있어서는 열려있고, 수정에 있어서는 닫혀 있는
    public static Singable createSinger(String name){
        if("BadSingerMember".equalsIgnoreCase(name)) {
            return new BadSingerMember();
        } else if ("GoodSingerMember".equalsIgnoreCase(name)) {
            return new GoodSingerMember();
        }
        return null;
    }

    public static Singable createSingerV2(String name) {
        try {
            Class<?> clazz = Class.forName(name);
          return (Singable) clazz.newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

}
