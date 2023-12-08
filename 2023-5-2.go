package main 

import(
    "fmt"
    "sort"
    // "math"
    "bufio"
    "strings"
    "strconv"
    "os"
) 

type rang struct{
    begin int
    end int 
}


func main(){

    reader := bufio.NewReader(os.Stdin)

    var seeds[] rang
    var mapa[][][]int
    
    line1, _ := reader.ReadString('\n')
    line1=line1[:len(line1)-1]
    words:=strings.Split(line1," ")

    for i:=1;i<len(words);i+=2{
        nr1,_:=strconv.Atoi(words[i])
        nr2,_:=strconv.Atoi(words[i+1])

        r:=rang{nr1,nr1+nr2-1}
        seeds = append(seeds, r)
    }
    

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
            sort.Slice(temp, func(i,j int)bool{return temp[i][1]<temp[j][1]})
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

    sort.Slice(temp, func(i,j int)bool{return temp[i][1]<temp[j][1]})
    mapa = append(mapa, temp)

    sort.Slice(seeds, func(i,j int)bool{return seeds[i].begin<seeds[j].begin})

    // fmt.Println(mapa)
    // for i:=0;i<len(seeds);i++{
    //     fmt.Println(seeds[i].begin, " ", seeds[i].end)
    // }

    for i:=1;i<len(mapa);i++{

        var temp2 []rang
        // fmt.Println(temp2)

        for k:=0;k<len(seeds);k++{

            curr:=seeds[k]

            for j:=0;j<len(mapa[i]);j++{

                newRang:=rang{-1,-1}
                filtrRang:=rang{mapa[i][j][1],mapa[i][j][1]+mapa[i][j][2]-1}
                filtrValue:=mapa[i][j][0]


                if (curr.begin >= filtrRang.begin && curr.begin<=filtrRang.end) && (curr.end >= filtrRang.begin && curr.end<=filtrRang.end) {
                    newRang.begin=filtrValue+(curr.begin-filtrRang.begin)
                    newRang.end=filtrValue+(curr.end-filtrRang.begin)
                    temp2=append(temp2,newRang)

                    curr.begin=-1
                    curr.end=-1
                }

                if !(curr.begin >= filtrRang.begin && curr.begin<=filtrRang.end) && (curr.end >= filtrRang.begin && curr.end<=filtrRang.end) {

                    newRang.begin=curr.begin
                    newRang.end=filtrRang.begin
                    temp2=append(temp2,newRang)

                    newRang.begin=filtrValue
                    newRang.end=filtrValue+(curr.end-filtrRang.begin)
                    temp2=append(temp2,newRang)

                    curr.begin=-1
                    curr.end=-1
                }
                if (curr.begin >= filtrRang.begin && curr.begin<=filtrRang.end) && !(curr.end >= filtrRang.begin && curr.end<=filtrRang.end) {

                    newRang.begin=filtrValue+(curr.begin-filtrRang.begin)
                    newRang.end=filtrValue+(filtrRang.end-filtrRang.begin)
                    temp2=append(temp2,newRang)

                    curr.begin=filtrRang.end+1
                }

                if curr.begin < filtrRang.begin && curr.end>filtrRang.end {

                    newRang.begin=curr.begin
                    newRang.end=filtrRang.begin
                    temp2=append(temp2,newRang)

                    newRang.begin=filtrValue
                    newRang.end=filtrValue+(filtrRang.end-filtrRang.begin)
                    temp2=append(temp2,newRang)

                    curr.begin=filtrRang.end+1
                }

            }
            if curr.end!=-1 {
                temp2=append(temp2,curr)
            }
        }

        sort.Slice(temp2,func(i,j int)bool{return temp2[i].begin<temp2[j].begin})

        seeds=temp2

        // break
    }

    for i:=0;i<len(seeds);i++{

        fmt.Println(seeds[i].begin," ",seeds[i].end)
    }
    fmt.Println("wynik: ", seeds[0].begin)

}
