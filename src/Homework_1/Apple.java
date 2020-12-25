package Homework_1;

public class Apple extends Fruits {
    public Apple() {
    }
    public Apple getInstanceOfT(Class<Apple> aClass) throws IllegalAccessException, InstantiationException {
        return aClass.newInstance();
    }


    @Override
    public Float getWeight() {
        return 1.0f;
    }
}
