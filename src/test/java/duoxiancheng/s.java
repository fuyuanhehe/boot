package duoxiancheng;

class Thread_2 implements Runnable{
    private ResDemo resdemo;

    public Thread_2(ResDemo resdemo) {
        super();
        this.resdemo = resdemo;
    }

    @Override
    public void run() {
        for(int i=1;i<10;i++){
            System.err.println("消费-"+ i+"--------");
            this.resdemo.sumer();
        }


    }

}