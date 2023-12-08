package main

import(
    // "math"
    "fmt"
    // "sort"
    "bufio"
    "strings"
    // "strconv"
    "os"
) 


type node struct{
    left,right string
}


func nwd(a,b uint64)uint64{
    if a>0 {
        a=a%b
        b-=a
        return nwd(a,b)
    }
        
    return b
}

func main(){

    reader := bufio.NewReader(os.Stdin)
    
    line, _ := reader.ReadString('\n')
    line=line[:len(line)-1]
    path:=[]rune(line)
    var nodes[] string
    line, _ = reader.ReadString('\n')

    mapa:=make(map[string]node)

    for{

        line, _ := reader.ReadString('\n')
        if(len(line)==0){
            break
        }

        line=line[:len(line)-1]
        line=strings.Replace(line,"(","",-1)
        line=strings.Replace(line,")","",-1)
        line=strings.Replace(line,",","",-1)
        line=strings.Replace(line,"=","",-1)

        words:=strings.Fields(line)

        newNode:=node{words[1],words[2]}
        mapa[words[0]]=newNode
        nodes = append(nodes, words[0])
    }

    var nwds[]uint64

    for i:=0;i<len(nodes);i++{
        indx:=0
        var wynik uint64=0
        if(nodes[i][len(nodes[i])-1]=='A'){
            curr:=nodes[i]
            for{
                if(indx==len(path)){
                    indx=0
                }
                //fmt.Println(curr, string(path[indx]))

                if(curr[len(curr)-1]=='Z'){
                    break
                }

                if(path[indx]=='L'){
                    curr=mapa[curr].left
                }else{
                    curr=mapa[curr].right
                }

                wynik++
                indx++
            }
            nwds = append(nwds, wynik)
        }
        //fmt.Println(wynik)
    }
    //fmt.Println("nwds: ",nwds)

    var curr uint64=nwds[1]*nwds[0]/(nwd(nwds[1],nwds[0]))
    for i:=2;i<len(nwds);i++{
        curr=curr*nwds[i]/nwd(curr,nwds[i])
    }

    fmt.Println(curr)
    // //fmt.Println(nwd(45, 95))
    
    

}
