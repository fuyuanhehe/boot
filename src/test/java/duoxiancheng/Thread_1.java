package duoxiancheng;

public class Thread_1 implements Runnable{
    private ResDemo resdemo;

    public Thread_1(ResDemo resdemo) {
        super();
        this.resdemo = resdemo;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.err.println("生产"+i+"++++++");
            this.resdemo.pro();
        }



    }

}