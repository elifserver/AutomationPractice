package Utils;

public enum APIResourceEnum {
    RegisterAPI("/api/register"),
    ListAPI("/api/users"); //?page=3

    String resource;

    APIResourceEnum(String resource) {
        this.resource = resource;
    }

    public String getResource(){
        return resource;
    }

}
