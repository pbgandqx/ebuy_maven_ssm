package com.lcvc.ebuy_maven_ssm.test;

import java.util.HashMap;
import java.util.Map;

public class CartTest {
    public static void main(String[] args){
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("冰淇淋",1);
        map.put("南瓜饼",1);
        map.put("烧鸭饭",1);
        System.out.println("第一次购买："+map);
        //再购买3个南瓜饼
        int newNumber=3;//新放入购物车的南瓜饼是3个
        if (map.containsKey("南瓜饼")){//如果包含南瓜饼
            int number=map.get("南瓜饼");//获取原来购物车的南瓜饼数量
            number=number+newNumber;//计算出购物车中南瓜饼的最终数量
            map.put("南瓜饼",number);
        }else{
            map.put("南瓜饼",newNumber);
        }
        System.out.println("第二次购买："+map);
    }
}
