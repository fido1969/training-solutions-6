package week12.d01;

import java.util.*;

public class GoodsPacker {

    private int highValue;
    private List<Good> goodList;
    private List<AddedGood> addedGoods = new ArrayList<>();
    private List<AddedGood> hingValueList = new ArrayList<>();


    private List<Good> getSortedGoods(int[][] goods,int capacity) {
        List<Good> goodList = new ArrayList<>();
        int counter = 0;
        for (int i =0; i<goods.length; i++) {
            if (goods[i][0] < capacity) {
                goodList.add(new Good(goods[i][0], goods[i][1]));
            }
        }
        goodList.sort(Comparator.reverseOrder());
        return goodList;
    }

    private List<Good> cutAktList(List<Good> oldList) {
        List<Good> aktList = new ArrayList<>();
        for (int i = 1; i< oldList.size();i++){
            aktList.add(oldList.get(i));
        }
        if (aktList.isEmpty()){
            record();
        }
        return aktList;
    }

    private int getFullWeight() {
        int sumWeight =0;
        for (AddedGood addedGood : addedGoods) {
            sumWeight += addedGood.getWeight();
        }
        return sumWeight;
    }

    private int getFullPrice() {
        int sumPrice =0;
        for (AddedGood addedGood : addedGoods) {
            sumPrice += addedGood.getValue();
        }
        return sumPrice;
    }

    private void record() {
        if (highValue< getFullPrice()) {
            highValue =getFullPrice();
            hingValueList.clear();
            Iterator<AddedGood> it = addedGoods.iterator();
            AddedGood addedGood;
            while (it.hasNext()) {
                addedGood = it.next();
                if (addedGood.getQuantity() > 0) {
                    hingValueList.add(new AddedGood(addedGood.getGood(), addedGood.getQuantity()));
                } else {
                    it.remove();
                }
            }
            System.out.println(getFullPrice());
        }
    }

    private void fillPlace(List<Good> aktList, int capacity) {
        if (aktList == null || aktList.isEmpty()) {
            return;
        }
        if (capacity >= aktList.get(0).getWeight()) {
            int quantity;
            for (Good good : aktList) {
                AddedGood addedGood = new AddedGood(good,capacity/good.getWeight());
                capacity -= addedGood.getWeight();
                addedGoods.add(addedGood);
                for (int i = 0; i<=addedGood.getQuantity(); i++){
                    fillPlace(cutAktList(aktList), capacity);
                    addedGood.removeOne();
                    capacity += addedGood.getGood().getWeight();
                }
                addedGoods.remove(addedGood);
            }
        } else {
            fillPlace(cutAktList(aktList),capacity);
        }
    }

    public int packGoods (int[][] goods,int capacity) {
        goodList = getSortedGoods(goods,capacity);
        for (Good good : goodList) {
            fillPlace(goodList, capacity);
        }
        return hingValueList.size();
    }

    public List<AddedGood> getHighValueList() {
        return hingValueList;
    }

    public static void main(String[] args) {
        GoodsPacker gp = new GoodsPacker();
        int[][] goodArray = {{1,20},{7,160},{3,90},{4,100},{5,120}};
        System.out.println(gp.packGoods(goodArray, 20));
        System.out.println(gp.getHighValueList());

    }
}

//    Készíts egy GoodsPacker osztályt, melynek van egy int packGoods(int[][] types, int capacity) metódusa. A types tömb
//        számpárokat tartalmaz, melyek tárgyak súlyát és értékét tartalmazzák, például: [(7, 160), (3, 90), (2, 15)].
//        Az első szám a súly kilogrammban, a második szám az érték forintban. A feladat az, hogy kiszámoljuk, hogy a
//        megadott táskamérethez (capacity) mennyi a tárgyak maximum értéke, amit belepakolhatunk a táskába.
//        Például ha a types [(7, 160), (3, 90), (2, 15)] és a capacity 20, akkor a maximum érték 555.