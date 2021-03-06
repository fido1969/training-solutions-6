package week06.d02;

public class StockByCategory {
    private int frozenQty;
    private int diaryQty;
    private int bakedGoodsQty;
    private int otherQty;

    public void addToStock(Category category) {
        switch (category.name()) {
            case "FROZEN":
                frozenQty++;
                break;
            case "DAIRY":
                diaryQty++;
                break;
            case "BAKEDGOODS":
                bakedGoodsQty++;
                break;
            case "OTHER":
                otherQty++;
                break;
            default:
                throw new IllegalArgumentException("Unknown category " + category.name() + " in StockByCategory");
        }
    }

    @Override
    public String toString() {
        return String.format("frozenQty: "+ frozenQty +
                ", diaryQty: " + diaryQty +
                ", bakedGoodsQty: " +bakedGoodsQty +
                ", otherQty: " + otherQty);
    }

    public int getFrozenQty() {
        return frozenQty;
    }

    public int getDiaryQty() {
        return diaryQty;
    }

    public int getBakedGoodsQty() {
        return bakedGoodsQty;
    }

    public int getOtherQty() {
        return otherQty;
    }

}
