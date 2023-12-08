package main 

import(
    "fmt"
    "math"
    "bufio"
    "strings"
    "strconv"
    "os"
) 

// var wynik int
// var power[] int
// var cards[1000]int
func main(){

    reader := bufio.NewReader(os.Stdin)

    var seeds[] int
    var mapa[][][]int
    wynik:=-1

    
    line1, _ := reader.ReadString('\n')
    line1=line1[:len(line1)-1]
    words:=strings.Split(line1," ")
    for i:=1;i<len(words);i+=2{
        nr1,_:=strconv.Atoi(words[i])
        nr2,_:=strconv.Atoi(words[i+1])
        for j:=0;j<nr2;j++{
            seeds = append(seeds, nr1+j)

        }
    }
    // fmt.Println(seeds)

    indx:=0
    indy:=0
    var temp[][] int
    for{
        
        line, _ := reader.ReadString('\n')
        if len(line)==0 {
            break
        }
        if(len(line)==1){
            continue
        }

        
        line=line[:len(line)-1]
        words:=strings.Split(line," ")

        _,err:=strconv.Atoi(words[0])
        if err!=nil{
            // fmt.Println(temp)
            mapa = append(mapa, temp)
            var newTemp[][]int
            temp = newTemp
            indx++
            indy=0
            continue
        }
        
    
        var tempLine[]int
        for i:=0;i<len(words);i++{
            nr,_:=strconv.Atoi(words[i])
            tempLine=append(tempLine, nr)
        }
        temp=append(temp, tempLine)
        indy++
    }

    mapa = append(mapa, temp)
    for i:=0;i<len(mapa);i++{
        fmt.Println(mapa[i])

    }
    
    for i:=0;i<len(seeds);i++{
        current:=seeds[i]
        for j:=1;j<len(mapa);j++{
            for k:=0;k<len(mapa[j]);k++{
                fmt.Println(current, " ", mapa[j][k][0]," ", mapa[j][k][1], " ", mapa[j][k][2])
                if(current>=mapa[j][k][1] && current<(mapa[j][k][1]+mapa[j][k][2])){
                    current=mapa[j][k][0]+(current-mapa[j][k][1])
                    break
                }
                fmt.Print(current, " ")
            }
            fmt.Println()
        }
        fmt.Println()
        if(wynik==-1){
            wynik=current
        }else{
            wynik = int(math.Min(float64(wynik),float64(current)))
        }
    }


    fmt.Println("wynik: ", wynik)


}
