package main

import (
    "bufio"
    "math"
    "os"
    "strings"
    "strconv"
    "fmt")

// var bag =[3]int{12,13,14} //red green blue
//
// func check(tab[3] int) bool{
//     is := true
//     for i:=range tab{
//         // fmt.Print(tab[i], " : " , bag[i], ",  ")
//         if tab[i]>bag[i]{
//             is = false
//         }
//     }
//     return is
// }

// "fmt"

func main()  {
    reader := bufio.NewReader(os.Stdin)
    wynik:=0
    // sum:=&wynik
    for {
        line, _ := reader.ReadString('\n')
        if len(line)==0 {
            break
        }
        line=strings.Replace(line,",","",-1)
        // line=strings.Replace(line,";","",-1)
        line=strings.Replace(line,":","",-1)
        words:=strings.Split(line," ")

        maxBag:=[3]int{0,0,0}
        // newBag:=[3]int{0,0,0}
        size := len(words)

        // ifAdd:=true
        
        for i:= 2;i<size;i+=2{

            nr,_:=strconv.Atoi(words[i])
            color:=words[i+1]


            if(color[len(color)-1] == ';'||color[len(color)-1] == '\n'){
                color=color[:len(color)-1]
                // fmt.Println("new color: ", color)
            }
            fmt.Println(nr," '",color,"'")

            if(color == "red"){
                maxBag[0]=int(math.Max(float64(maxBag[0]),float64(nr)))
            }else if(color == "green"){
                maxBag[1]=int(math.Max(float64(maxBag[1]),float64(nr)))
            }else{
                maxBag[2]=int(math.Max(float64(maxBag[2]),float64(nr)))
            }
        }
            
        fmt.Println(maxBag)
        toAdd:=1
        for i:= range maxBag{
            toAdd*=maxBag[i]
        }
        wynik+=toAdd
        // if !check(maxBag){
        //     ifAdd=false
        // }
        // if ifAdd{
        //     nr,_:=strconv.Atoi(words[1])
        //     *sum+=nr
        // }
    }
    fmt.Println(wynik)
}
