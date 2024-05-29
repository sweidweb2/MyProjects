

const mygrid=document.querySelector(".grid");

const score=document.getElementById("score");

let startbtn=document.getElementById("start");

let squares=[];

let currentsnake=[2,1,0];

let direction=1;

const width=10;

let appleindex=0;

let myscore=0;

let speed=0.8;

let intervaltime=1000;

let timerid=0;

/*=========================================================*/
//creating 100 mini-div
function creategrid()
{
    
    for(let i=0;i<width*width;i++)
    {
        const square=document.createElement("div");

        square.classList.add("square");

        squares.push(square);

        mygrid.appendChild(square);
        
    }
};
creategrid()

//coloring default snake
currentsnake.forEach(function(index)
{
    squares[index].classList.add("snake");
});

//start game
function startgame()
{
    clearInterval(timerid);
    //remove snake
    currentsnake.forEach(function(index)
    {
        squares[index].classList.remove("snake");
    });
    //remove apple
    squares[appleindex].classList.remove("apple");

    currentsnake=[2,1,0];
    //new score to browser
    myscore=0;
    score.textContent=myscore;

    //reset direction/interval/generate default apple
    direction=1;
    intervaltime=1000;
    generateapples();

    //recreating default snake
    currentsnake.forEach(function(index)
    {
        squares[index].classList.add("snake");
    });


    timerid=setInterval(move,intervaltime);
};

//moving the snake
function move()
{
    //if hitiing border or itself to stop game
    if(
        (currentsnake[0]+width>=100 && direction===width) || //the snake hit the bottom
        (currentsnake[0]%width===9 && direction===1) ||//the snake hit the right
        (currentsnake[0]%width===0 && direction===-1) ||//the snake hit the left
        (currentsnake[0]-width<0 && direction===-width) ||//the snake hit the top
        squares[currentsnake[0]+direction].classList.contains("snake")

    )
    return clearInterval(timerid);

    //how to move
    const tail=currentsnake.pop();

    squares[tail].classList.remove("snake");

    currentsnake.unshift(currentsnake[0]+direction);

    squares[currentsnake[0]].classList.add("snake");

    if(squares[currentsnake[0]].classList.contains("apple"))
    {
        //remove the class apple
        squares[currentsnake[0]].classList.remove("apple");

        //grow our snake by adding class of snake to it
        squares[tail].classList.add("snake");

        //grow our snake array
        currentsnake.push(tail);

        //generate new apple
        generateapples();

        //add one to the score
        myscore++;
        score.textContent=myscore;

        //speed up our snake
        clearInterval(timerid);
        intervaltime=intervaltime*speed;
        timerid=setInterval(move,intervaltime);
    }

}


//when tapping an arrow to set direction
document.addEventListener("keyup",control);

function control(e){
    if(e.keyCode===37)
    {
        //left
        direction=-1;
    }
    else if(e.keyCode===38)
    {
        //up
        direction=-width;
    }
    else if(e.keyCode===39)
    {
        //right
        direction=1;
    }
    else if(e.keyCode===40)
    {
        //down
        direction=width;
    }
}
//generate apples
function generateapples()
{
    do
    {
        appleindex=Math.floor(Math.random()*101)
    }while(squares[appleindex].classList.contains("snake"));

    squares[appleindex].classList.add("apple");
};

generateapples();

startbtn.addEventListener("click",startgame)


