package file;


import lambda.Person;

import java.io.*;


public class Foo {

    // 存 取 object
    public static void main(String[] args) throws Exception {

        //在根目录下新建一个 io 的文件夹
        OutputStream op = new FileOutputStream("src/main/webapp/upload/aaaa.txt");
        ObjectOutputStream ops = new ObjectOutputStream(op);
        Person p = new Person();
        p.setAge(11);
        p.setFirstName("哈哈哈哈");
        ops.writeObject(p);
        ops.close();

      //  BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("src/main/webapp/upload/aaaa.txt")), "UTF-8"));
        //  bufferedWriter.write(p.toString());
      //  bufferedWriter.close();

        InputStream in = new FileInputStream("src/main/webapp/upload/aaaa.txt");
        ObjectInputStream os = new ObjectInputStream(in);
        byte[] buffer = new byte[10];
        int len = -1;
        Person p2 = (Person) os.readObject();
        System.out.println(p2);//Person [name=vae, age=1]
        os.close();


    }
}

