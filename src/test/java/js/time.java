package js;

public class time {

    // 获取当前系统时间戳
   // var time = parseInt(new Date().getTime() / 1000);

    // 将时间戳转换成日期格式：
/*    function timestampToTime(timestamp) {
        var date = new Date(timestamp * 1000);//时间戳为10位需*1000，时间戳为13位的话不需乘1000
        var Y = date.getFullYear() + '-';
        var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
        var D = date.getDate() + ' ';
        var h = date.getHours() + ':';
        var m = date.getMinutes() + ':';
        var s = date.getSeconds();
        return Y + M + D + h + m + s;
    }*/

 /*   var date = new Date('2014-04-23 18:55:49:123');
    // 有三种方式获取
    var time1 = date.getTime();
    var time2 = date.valueOf();
    var time3 = Date.parse(date);
	console.log(time1);//1398250549123
	console.log(time2);//1398250549123
	console.log(time3);//1398250549000*/



   /* var dateParse = Date.parse(new Date());//转成时间戳
      console.log( dateParse)
    var time = new Date(dateParse);//再转成标准时间
      console.log( time)
    var y = String(time.getFullYear());
    var m = String(time.getMonth()+1);
    var d = String(time.getDate());
    var h = String(time.getHours());
    var u = String(time.getMinutes());
    var s = String(time.getSeconds());
    //return m+"/"+d//直接输入自己想要的格式
      console.log( y+"-"+m+"-"+d)*/



    // 获取最近几天的日期
/*    getDay(day){
        let today = new Date();
        let targetday_milliseconds = today.getTime() + 1000*60*60*24*day;
        today.setTime(targetday_milliseconds); //注意，这行是关键代码
        let tYear = today.getFullYear();
        let tMonth = today.getMonth();
        let tDate = today.getDate();
        tMonth = this.doHandleMonth(tMonth + 1);
        tDate = this.doHandleMonth(tDate);
        return tYear+"-"+tMonth+"-"+tDate;
    },

    doHandleMonth(month){
        let m = month;
        if(month.toString().length == 1){
            m = "0" + month;
        }
        return m;
    },*/

  /*   let day = this.getDay(0);
      let day7 = this.getDay(-7);
      console.log(day)
      console.log(day7)*/

    // 获取最近6个月
   /* getMonths(){
        //创建现在的时间
        let data = new Date();
        //获取年
        let year = data.getFullYear();
        //获取月
        let mon = data.getMonth()+2;
        let arry = new Array();
        for(let i=0; i<6; i++){
            mon = mon - 1;

            if(mon <= 0 ){
                year = year-1;
                mon = mon + 12;
            }
            if(mon<10){
                mon="0"+mon;
            }
            arry[i] = year+"-"+mon;
        }
        return arry;
    },*/

}



