package test;

public enum  Color {


    RED(1,"红色"),BLANK(2,"黑色"),YELLOW(3,"黄色");

    private String name;
    private int code;

    Color(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static void main(String[] args) {


      //  System.out.println(Color.RED.getCode());
      //  System.out.println(Color.RED.getName());

     //   System.out.println(getThe(2));

       /* for (Color  s : Color.values()) {
            System.out.println(s.getCode());
            System.out.println(s.getName());
        }*/


        System.out.println(getThe(6));


    }

    public static Object getThe(int a ){
        Object o = null;

        switch (a){
            case 1:
            case 2:
                o = "红色";
               break;
            case 4:
                o = "黑色";
                break;
            case 3:
                o = "兰色";
                break;
                default:
                    o = "哈哈";
        }

        return o;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                ", code=" + code +
                '}';
    }
}
