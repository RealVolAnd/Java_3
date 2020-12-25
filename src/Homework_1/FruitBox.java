package Homework_1;

import java.util.ArrayList;
import java.util.List;

public class FruitBox<T extends Fruits> {
    private List<T> box;

    public FruitBox() {
        box=new ArrayList<>();
    }
    public void add(T fruit) {
        box.add(fruit);
    }
    public int getCount() {
        return box.size();
    }

    public float getWeight(){
        float result =0.0f;
        for (T fruit:box) {
            result+=fruit.getWeight();
        }
        return(result);
    }

    public boolean compare(FruitBox anotherBox){
        return(this.getWeight()== anotherBox.getWeight());
    }

    public void turnTo(FruitBox anotherBox){
        for(T fruit: box){
            anotherBox.add(fruit);
        }
        box.clear();
    }


}

