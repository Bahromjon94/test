package uz.technickpro.addtofavourite;

public class FavPojo {

    private int id;
    private String name;
    private String isFav;

    public FavPojo(int id, String name, String isFav) {
        this.id = id;
        this.name = name;
        this.isFav = isFav;
    }

    public FavPojo(String name, String isFav) {
        this.name = name;
        this.isFav = isFav;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String isFav() {
        return isFav;
    }

    public void setFav(String fav) {
        isFav = fav;
    }
}
