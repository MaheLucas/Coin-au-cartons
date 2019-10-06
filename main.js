const hamburger = document.getElementsByClassName(".hamburger"); 
document.addEventListener('click', function(){
    
}); 
new fullpage('#fullpage', {
   autoScrolling: true,
    navigation: true, 
    /*onleave: (origin, destination, direction) => {
    const section = destination.item; 
    const image = section.getElementById('anim'); 
    const tl = new TimelineMax({delay: 0.5}); 
    tl.formTo(image, 0.5, {
        y: 50,
        opacity: 0
    },{
        y:0,
        opacity: 1
    });
}*/
}); 