package main

import(
    // "math"
    "fmt"
    // "bufio"
    // "strings"
    // // "strconv"
    // "os"
) 

func binSearch1(left,right,time,dist uint64)uint64{
    var s uint64 =(left+right)/2

    if(left+1==right){
        if(left*(time-left)>dist){
            return left
        }else{
            return right
        }
    }
    if(left==right){
        return right
    }

    if(s*(time-s)>dist){
        return binSearch1(left,s,time,dist)
    }else{
        return binSearch1(s+1,right,time,dist)
    }
}

func binSearch2(left,right,time,dist uint64)uint64{
    var s uint64 =(left+right)/2

    if(left+1==right){
        if(right*(time-right)>dist){
            return right
        }else{
            return left
        }
    }
    if(left==right){
        return right
    }

    if(s*(time-s)>dist){
        return binSearch2(s,right,time,dist)
    }else{
        return binSearch2(left,s-1,time,dist)
    }
}

func main(){

    var wynik uint64=1

        var nr1,nr2 uint64
        fmt.Scanf("%d", &nr1)
        fmt.Scanf("%d", &nr2)

        wynik*=binSearch2(0,nr1,nr1,nr2)-binSearch1(0,nr1,nr1,nr2)+1
        // fmt.Println(wynik)
    fmt.Println("wynik: ",wynik)

}
