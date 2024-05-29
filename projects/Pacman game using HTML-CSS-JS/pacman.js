const width=28;
const grid=document.querySelector(".grid");
const scoredisplay=document.getElementById("score");
const btn=document.getElementById("btn");
let squares=[];
let score=0;

/*Code*/
// 0-pac dots
// 1-wall
// 2-ghost lair
// 3-power-pellet
// 4-empty

const layout=[
    1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,
    1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1,
    1,3,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,3,1,
    1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1,
    1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
    1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,
    1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,
    1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,
    1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,
    1,1,1,1,1,1,0,1,1,4,4,4,4,4,4,4,4,4,4,1,1,0,1,1,1,1,1,1,
    1,1,1,1,1,1,0,1,1,4,1,1,1,2,2,1,1,1,4,1,1,0,1,1,1,1,1,1,
    1,1,1,1,1,1,0,1,1,4,1,1,1,2,2,1,1,1,4,1,1,0,1,1,1,1,1,1,
    4,4,4,4,4,4,0,0,0,4,1,1,1,2,2,1,1,1,4,0,0,0,4,4,4,4,4,4,
    1,1,1,1,1,1,0,1,1,4,1,1,1,1,1,1,1,1,4,1,1,0,1,1,1,1,1,1,
    1,1,1,1,1,1,0,1,1,4,1,1,1,1,1,1,1,1,4,1,1,0,1,1,1,1,1,1,
    1,1,1,1,1,1,0,1,1,4,1,1,1,1,1,1,1,1,4,1,1,0,1,1,1,1,1,1,
    1,0,0,0,0,0,0,0,0,4,4,4,4,4,4,4,4,4,4,0,0,0,0,0,0,0,0,1,
    1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1,
    1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1,
    1,3,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,3,1,
    1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1,
    1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1,
    1,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0,1,
    1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,
    1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,0,1,
    1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,
    1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
]

function createboard(){
    for(let i=0;i<layout.length;i++){

        const mydiv=document.createElement("div");

        grid.appendChild(mydiv);

        squares.push(mydiv)
        

        if(layout[i]===0)
        {
            squares[i].classList.add("pac-dot");
        }else if(layout[i]===1)
        {
            squares[i].classList.add("wall")
        }else if(layout[i]===2){
            squares[i].classList.add("ghost-lair")
        }
        else if(layout[i]===3)
        {
            squares[i].classList.add("power-pellet")
        }
    }
}

createboard()

//starting position of pacman

let pacmancuurentindex=490;
squares[pacmancuurentindex].classList.add("pacman");

//control function
function control(e){
    squares[pacmancuurentindex].classList.remove("pacman");
    switch(e.keyCode){
    
    //key down
    case 40:
        if(!squares[pacmancuurentindex+width].classList.contains("wall") &&
            pacmancuurentindex+width<width*width &&
            !squares[pacmancuurentindex+width].classList.contains("ghost-lair"))
            {
                pacmancuurentindex+=width;
            }
        break;

    //key right
    case 39:
        if(!squares[pacmancuurentindex+1].classList.contains("wall") &&
            pacmancuurentindex%width<width-1 &&
            !squares[pacmancuurentindex+1].classList.contains("ghost-lair"))
            {
                pacmancuurentindex+=1;
                if(pacmancuurentindex===391){
                    pacmancuurentindex=364;
                }
            }
            
        break;

    //key up
    case 38:
        if(!squares[pacmancuurentindex-width].classList.contains("wall") &&
            pacmancuurentindex-width>=0 &&
            !squares[pacmancuurentindex-width].classList.contains("ghost-lair"))
            {
                pacmancuurentindex-=width;
            }
        break;

    //key left
    case 37:
        if(!squares[pacmancuurentindex-1].classList.contains("wall") && 
            pacmancuurentindex%width!==0 &&
            !squares[pacmancuurentindex-1].classList.contains("ghost-lair"))
            {
                pacmancuurentindex-=1;
                if(pacmancuurentindex===364){
                    pacmancuurentindex=391;
                }
            }
        break;
    }
    squares[pacmancuurentindex].classList.add("pacman");
    pacdoteaten();
    powerpelleteaten();
    checkforgameover();
    chechforwingame();
}

document.addEventListener("keyup",control)

function pacdoteaten(){
    if(squares[pacmancuurentindex].classList.contains("pac-dot")){
            squares[pacmancuurentindex].classList.remove("pac-dot");
            score=score+1;
            scoredisplay.innerHTML=score;
        }
}

function powerpelleteaten(){
    //if square pacman contains a power pellet
    if(squares[pacmancuurentindex].classList.contains("power-pellet"))
    {
        squares[pacmancuurentindex].classList.remove("power-pellet")
        score+=10;
        scoredisplay.innerHTML=score;

        ghosts.forEach(ghost=>ghost.isScared=true)

        setTimeout(unscaredghosts,10000)
    }
}

function unscaredghosts(){
    ghosts.forEach(ghost=>ghost.isScared=false)
    console.log("removed")
}

class Ghost{
    constructor(ghostname,startindex,speed)
    {
        this.ghostname=ghostname;
        this.startindex=startindex;
        this.speed=speed;
        this.currentindex=startindex;
        this.isScared=false;
        this.timerId=NaN;
    }
}

ghosts=[
    new Ghost("blinky",349,250),
    new Ghost("pinky",377,400),
    new Ghost("inky",350,230),
    new Ghost("clyde",378,500)
];

//drawing ghosts on grid
ghosts.forEach(ghost => {
    squares[ghost.currentindex].classList.add(ghost.ghostname)
    squares[ghost.currentindex].classList.add("ghost")
});

//move the ghosts
ghosts.forEach(ghost=>moveghost(ghost))


function moveghost(ghost){
    const directions=[-1,+1,-width,+width]
    let direction=directions[Math.floor(Math.random()*directions.length)]

    ghost.timerId=setInterval(function(){
        //code
        if(
            !squares[ghost.currentindex+direction].classList.contains("wall") &&
            !squares[ghost.currentindex+direction].classList.contains("ghost"))
        {
            //remove ghost
            squares[ghost.currentindex].classList.remove(ghost.ghostname);
            squares[ghost.currentindex].classList.remove("ghost","scared-ghost");

            //add direction to current index
            ghost.currentindex+=direction;

            //add ghost class
            squares[ghost.currentindex].classList.add(ghost.ghostname);
            squares[ghost.currentindex].classList.add("ghost")
        }
        else{
            direction=directions[Math.floor(Math.random()*directions.length)];
        }

        if(ghost.isScared===true){
            squares[ghost.currentindex].classList.add("scared-ghost")
        }

        if(squares[ghost.currentindex].classList.contains("pacman") && ghost.isScared===true){
            squares[ghost.currentindex].classList.remove(ghost.ghostname,"ghost","scared-ghost");
            ghost.currentindex=ghost.startindex;
            score+=100;
            scoredisplay.innerHTML=score;
        }
        checkforgameover();
        chechforwingame();
    },ghost.speed)

}

//check for game over

function checkforgameover(){
    if(squares[pacmancuurentindex].classList.contains("ghost")&&
        !squares[pacmancuurentindex].classList.contains("scared-ghost") )
        {
            ghosts.forEach(ghost=>clearInterval(ghost.timerId))

            document.removeEventListener("keyup",control)

            scoredisplay.innerHTML="you lost!"
        }
}

//chech for winning the game

function chechforwingame(){
    if(score>500)
    {
        ghosts.forEach(ghost=>clearInterval(ghost.timerId))

        document.removeEventListener("keyup",control)

        scoredisplay.innerHTML="Congrats,you won!"
    }
}

//button
// btn.addEventListener("click",function(){
//     createboard();
//     ghosts.forEach(ghost=>squares[ghost.currentindex].classList.remove(ghost.ghostname,"ghost","scared-ghost"))
//     ghosts.forEach(ghost=>ghost.currentindex=ghost.startindex)

//     squares[pacmancuurentindex].classList.remove("pacman")
//     pacmancuurentindex=490;
//     squares[pacmancuurentindex].classList.add("pacman");

//     score=0;
//     scoredisplay.innerHTML=score;
// });


