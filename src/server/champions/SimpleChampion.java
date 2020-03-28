package server.champions;

/**
 * Created by Michal Szarek
 **/
public class SimpleChampion {
    protected String name;
    protected String imgSuffix;

//    public SimpleChampion(String name, String imgSuffix) {
//        this.name = name;
//        this.imgSuffix = imgSuffix;
//    }


    public void setName(String name) {
        this.name = name;
    }

    public void setImgSuffix(String imgSuffix) {
        this.imgSuffix = imgSuffix;
    }

    @Override
    public String toString() {
        return "{\"name\":" + "\"" + name + "\",\"suffix\":" + "\"" + imgSuffix + "\",}";
    }
}
