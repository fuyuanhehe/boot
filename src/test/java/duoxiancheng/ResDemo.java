package duoxiancheng;

public class ResDemo {
    private int num;
    private boolean flag;
    public ResDemo(int num, boolean flag) {
        super();
        this.num = num;
        this.flag = flag;
    }
    public synchronized void pro(){
        if(flag){
            System.out.println("仓库有货，不用生产");
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.flag=true;
        this.num++;
        System.out.println(Thread.currentThread().getName()+"生产商品:::::有"+num+ "个");
        notify();
    }
    public synchronized void sumer(){
        if(!flag){
            System.out.println("仓库里没有货，不能消费");
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        this.flag=false;
        this.num--;
        System.out.println(Thread.currentThread().getName()+"消费商品::::::"+num);
        notify();



    }


        public static void main(String[] args){
            ResDemo resdemo=new ResDemo(0, false);
            Thread thread1=new Thread(new Thread_1(resdemo),"thread1");
            Thread thread2=new Thread(new Thread_2(resdemo),"thread2");
            thread2.start();
            thread1.start();


        }




}