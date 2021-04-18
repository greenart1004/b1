// index
function demo(){
    alert("Thymeleaf with Css and JS demo");
}





//modify
// $(document).ready(function(){
//     $('h1').css({'color' : 'red'});
// });


// 1.CSS 속성을 변경하기 위해 CSS() 메소드를 사용한다============================================
$(function(){
    $('h1').css({'color' : 'red'});

//   $('#12 .form-group .form-control').css('text-decoration' , 'underline');

//   $('#12 .form-group .form-control').css('border-bottom' , '20px solid red');

//   $('#12 .form-group .form-control').css('transform' , 'rotate(0deg)');

//   $('#12 .form-group .form-control').css('opacity' , '2');


    $('#12 .form-group .form-control').css({
        textDecoration : 'underline',
    //    borderBottom : '20px solid red',
        transform : 'rotate(0deg)',
        opacity : 2
    });


    // 2. 실행시점을 제어하기 위해 .ON() .OFF 메소드를 사용한다 ==========================================
    //  $('선택자').ON('이벤트종류', 할일)     ===>     $('선택자').ON('이벤트종류', function(){});
    //  1-----------------------1------------------------------------
    // $('h1').on('mouseover', function(){
    //     $('h1').css('background-color' , 'green');
    // })
    // $('h1').on('mouseout', function(){
    //     $('h1').css('background-color' , '#3498db');
    // });
    //  2-------------------------2----------------------------------
    // $('h1').on('mouseover', function(){
    //     $('h1').css('background-color' , 'green');
    // }).on('mouseout', function(){
    //     $('h1').css('background-color' , '#3498db');
    // });
    //  3-------------------------3----------------------------------
    // 
    // $('h1, #12 .form-group .form-control').mouseover(function(){
    //     $('h1').css('background-color' , 'green');
    // }).mouseout(function(){
    //     $('h1').css('background-color' , '#3498db');
    // });
    //  4-------------------------4----------------------------------
    // this 이벤트가 일어난 그 요소
    // $('h1, #12 .form-group .form-control').mouseover(function(){
    //     $(this).css('background-color' , 'green');
    // })
    // .mouseout(function(){
    //     $(this).css('background-color' , '#3498db');
    // });
  
         
    $("#target .ddd").click(function(){
        var value = $("#target .form-control").val();
        if(value == ""){
	         alert("error");
        }
	 });     
     
     $("#aaaaa .bbbb").click(function(){
        var value = $("#aaaaa .form-group-1 .form-control-1").val();
        if(value == 0){
	         alert(" 내용을 입력해주세요");
        }
	 });  

     $("#aaaaa .bbbb").click(function(){
        var ccc = $("#aaaaa .form-group-2 .form-control-2").val();
        if(ccc == 0){
	         alert(" 내용을 입력해주세요");
        }
	 }); 






});  

