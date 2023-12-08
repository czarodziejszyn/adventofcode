package main 

import(
    "fmt"
    // "math"
    "bufio"
    "strings"
    "strconv"
    "os"
) 

var wynik int
var power[] int
var cards[1000]int

// func countPower(){
//     power=append(power,1)
//     for i:=1;i<=27;i++{
//         power=append(power,power[i-1]*2)
//     }
// }

func main(){
    wynik = 0
    // countPower()
    reader := bufio.NewReader(os.Stdin)
    indx:=0
    for{
        line, _ := reader.ReadString('\n')
        if len(line)==0 {
            break
        }
        cards[indx]++
        indx++
        line=line[:len(line)-1]
        // line=strings.Replace(line," ","",-1)
        line=strings.Replace(line,":","",-1)
        line=strings.Replace(line,"   "," ",-1)
        line=strings.Replace(line,"  "," ",-1)
        words:=strings.Split(line," ")
        // fmt.Println(words)
        var wining[]int
        stillRead:=true
        pot:=-1
        for i:=2;i<len(words);i++{
            if words[i]==string('|'){
                stillRead=false
                continue
            }
            nr,_:=strconv.Atoi(words[i])
            if stillRead{
                wining=append(wining, nr)
            }else{
                czyJest:=false
                for j:=0;j<len(wining);j++{
                    if nr==wining[j]{
                        czyJest=true
                        wining[j]=-1
                    }
                }
                if czyJest{
                    pot++
                    
                }
            }
        }
        fmt.Println(pot)
        if(pot!=-1){
            for i:=0;i<=pot;i++{
                cards[indx+i]+=cards[indx-1]
            }
        }
    }
    for i:=0;i<1000;i++{
        fmt.Println("card nr: ", i+1, ", ", cards[i]," times")
        wynik+=cards[i]

    }
    fmt.Println(wynik)

}

