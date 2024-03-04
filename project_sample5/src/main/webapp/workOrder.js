window.addEventListener("load", function () {
console.log(userRole);
    let id = "admin";

    document.querySelector("#admin-change-button")
        .addEventListener("click", function () {
            id = "admin";
            userCheck(id);
        });
    document.querySelector("#user")
        .addEventListener("click", function () {
            id = "user";
            userCheck(id);
        });

    menuHover();
    popup();
    retouchPopup()
//    popupRun();
//    retouchPopupRun();
    imgAtt();
    userCheck(id);

});

function menuHover() {

    const hover = document.querySelectorAll('a.hover');
    const menuBar = document.querySelector('.menu-bar');
    const nav = document.querySelector('nav');
    const wrap = document.querySelector('.wrap');

    const workerGrade = document.querySelector(".workerGrade");

    // 모바일 스크립트 코드
    const hamburgerMenu = document.querySelector('.hamburger-menu');
    const myPage = document.querySelector('#myPage');

    hamburgerMenu.addEventListener('click', function () {
        nav.classList.toggle('active');

        if (nav.classList.contains('active')) {
            nav.prepend(myPage);
            myPage.style.display = 'flex';
            myPage.style.padding = '5px 0';
            myPage.style.backgroundColor = '#dde';
            workerGrade.style.display = "inline";

            let sectionHeight = section.offsetHeight;
            nav.style.height = `${sectionHeight}px`;
        } else {
            workerTitle.appendChild(myPage);
            myPage.style.display = '';
            nav.style.height = '';
            workerGrade.style.display = "none";
        }
    });

    const section = document.querySelector('section');




    // if() {
    // document.querySelector("#mainTitle1").style.display = "block";
    // } else {
    document.querySelector("#mainTitle2").style.display = "block";
    // }

    let isHovered = false;

    hover.forEach(button => {
        button.addEventListener('mouseover', () => {
            showMenuBar();
            isHovered = true;
        });
    });

    wrap.addEventListener("mouseleave", function () {
        if (!isHovered) {
            hideMenuBar();
        }
    });

    menuBar.addEventListener("mouseenter", function () {
        isHovered = true;
    });

    menuBar.addEventListener("mouseleave", function () {
        hideMenuBar();
    });

    section.addEventListener("click", function () {
        hideMenuBar();
    })

    function showMenuBar() {
        nav.classList.add('active');
    }

    function hideMenuBar() {
        nav.classList.remove('active');
    }

    hover.forEach(link => {
        link.addEventListener("click", function (event) {
            let myPage = document.querySelector("#myPage");
            // let myPageName = document.querySelector("#workerName");
            // let myPageLogo = document.querySelector("#myPageLogo");
            let menuBar = document.querySelector(".menu-bar");
            let mainPage = document.querySelector(".wrap");
            let companyLogo = document.querySelector("#workerLogo");

            let ulLi = document.querySelectorAll(".menu-bar-content ul li");


            event.preventDefault();
            if (nav.classList.contains('active') && window.matchMedia("(max-width: 430px)").matches) {
                nav.style.height = `${section.offsetHeight}px`

                // 네비4
                // for (let i = 0; i < ulLi.length; i++) {
                //     ulLi[i].style.padding = '10px';
                //     ulLi[i].style.margin = '0px';
                // }

                // 네비5
                for (let i = 0; i < ulLi.length; i++) {
                    ulLi[i].style.padding = '7px';

                }
                menuBar.prepend(myPage);
            }
        });
    });

    

    // document.querySelector("#adminTitle").style.display = 'none';
    // document.querySelector("#adminNav").style.display = 'none';
}

function userCheck(id) {

    const delete_checkbox = document.querySelectorAll(".delete-checkbox");
    const menubarContent = document.querySelector(".menu-bar-content");

    if (id == "user") {
        document.querySelector("#mainTitle2").style.display = "none";
        document.querySelector("#mainTitle1").style.display = "block";
        document.querySelector(".button-div").style.display = "none";
        document.querySelector(".user-button-div").style.display = "block";
        document.querySelector("#adminTitle").style.display = 'none';
        document.querySelector("#adminNav").style.display = 'none';
        document.querySelector(".workerGrade").innerHTML = '작업자<br>';
       

        for (let i = 0; i < menubarContent.length; i++) {
            menubarContent[i].style.marginLeft = "40px";
        };

        for (let i = 0; i < delete_checkbox.length; i++) {
            delete_checkbox[i].style.display = "none";
        };

    } else if (id == "admin") {
        document.querySelector("#mainTitle2").style.display = "block";
        document.querySelector("#mainTitle1").style.display = "none";
        document.querySelector(".button-div").style.display = "block";
        document.querySelector(".user-button-div").style.display = "none";
        document.querySelector("#adminTitle").style.display = 'block';
        document.querySelector("#adminNav").style.display = 'block';
        document.querySelector(".workerGrade").innerHTML = '관리자<br>';
        
        for (let i = 0; i < menubarContent.length; i++) {
            menubarContent[i].style.marginLeft = "0";
        };

        for (let i = 0; i < delete_checkbox.length; i++) {
            delete_checkbox[i].style.display = "block";
        };

    }

}


function popup() {

    // 품질검사 지침서 팝업
    // 팝업 div 랑 버튼가져오기
    const order_add_popup = document.getElementById("order-add-popup");
    const list_add_button = document.getElementById("list-add-button");
    const cancel_apply_button = document.getElementById("cancel-apply-button");


    // 팝업 div 열기
    list_add_button.addEventListener("click", function () {

        document.querySelector("#add-title").value = "";
        document.querySelector("#add-detail").value = "";
        document.querySelector("#add-img").value = "";

        order_add_popup.style.display = "block";
        // 다른영역 클릭 비활성화
        order_add_popup.style.pointerEvents = "auto";
    });

    // 팝업 div 닫기 => 닫기버튼누를시
    cancel_apply_button.addEventListener("click", function () {
        order_add_popup.style.display = "none";
        // 다른영역 클릭 활성화
        order_add_popup.style.pointerEvents = "none";
    });

    // 팝업 div 닫기버튼 비활성화
    order_add_popup.addEventListener("click", function (event) {
        event.stopPropagation();
    });

    // 팝업 div 닫기버튼 활성화
    window.addEventListener("click", function (event) {
        if (event.target == order_add_popup) {
            order_add_popup.style.display = "none";
            // 다른영역 클릭 활성화
            order_add_popup.style.pointerEvents = "none";
        }
    });

}


//function checkDelete() {
//
//    document.querySelector("#list-delete")
//        .addEventListener("click", function () {
//
//            console.log("작동중");
//
//            // 선택된 체크박스들을 선택
//            let div_checked = document.querySelectorAll(".delete-check:checked");
//
//            // for(let i = 0; i < div_checked.length; i++) {
//            //     div_checked[i].parentNode.remove();
//            // }
//            
//
//            // 선택된 리스트 지우기
//            div_checked.forEach(function (checkbox) {
//
//                checkbox.closest('.workList').remove();
//            });
//
//        });
//
//};


function retouchPopup() {

    // 품질검사 지침서 팝업
    // 팝업 div 랑 버튼가져오기
    const order_retouch_popup = document.getElementById("order-retouch-popup");
    const list_retouch_button = document.getElementById("list-retouch-button");
    const retouch_cancel_apply_button = document.getElementById("retouch-cancel-apply-button");


    // 팝업 div 열기
    list_retouch_button.addEventListener("click", function () {

        document.querySelector("#retouch-title").value = "";
        document.querySelector("#retouch-detail").value = "";
//        document.querySelector("#retouch-img").value = "";

        order_retouch_popup.style.display = "block";
        // 다른영역 클릭 비활성화
        order_retouch_popup.style.pointerEvents = "auto";
        
        
        // 체크된 체크박스 가져오기
        let checked = document.querySelectorAll(".delete-check:checked");

        // 폼에 추가할 데이터 넣어주기
        let form = document.querySelector(".retouch-note");       
        
        checked.forEach(function(checkbox) {
			
		    let input = document.createElement("input");
		    input.type = "hidden";
		    input.name = "checkValue";
		    input.value = checkbox.value;
		
		    form.appendChild(input);
		});
        
    });

    // 팝업 div 닫기 => 닫기버튼누를시
    retouch_cancel_apply_button.addEventListener("click", function () {
		console.log("닫기버튼누름");
        order_retouch_popup.style.display = "none";
        // 다른영역 클릭 활성화
        order_retouch_popup.style.pointerEvents = "none";
    });

    // 팝업 div 닫기버튼 비활성화
    order_retouch_popup.addEventListener("click", function (event) {
        event.stopPropagation();
    });

    // 팝업 div 닫기버튼 활성화
    window.addEventListener("click", function (event) {
        if (event.target == order_retouch_popup) {
            order_retouch_popup.style.display = "none";
            // 다른영역 클릭 활성화
            order_retouch_popup.style.pointerEvents = "none";
        }
    });

}




function imgAtt() {
    let chooseFile = document.getElementById('add-img-button');
    let retouchFile = document.getElementById('retouch-apply-button');
    let fileButton = document.getElementById('file-button');
    let imgSelectButton = document.getElementById('img-select-button');
    let imgRetouchButton = document.getElementById('img-retouch-button');
    let fileNameDisplay = document.getElementById('fileName');
    let imgURLInput = document.getElementById('add-img');
    let imgRetouchURLInput = document.getElementById('retouch-img');
    let img_preview = document.querySelector(".img-preview");
    let selectedFile;

    console.log("imgAtt function called");

    chooseFile.addEventListener('change', function (event) {
        event.stopPropagation();
        event.preventDefault();        

        selectedFile = chooseFile.files && chooseFile.files.length > 0 ? chooseFile.files[0] : null;

		console.log(chooseFile.files[0]);

        if (selectedFile) {
            fileNameDisplay.textContent = selectedFile.name;
        } else {
            fileNameDisplay.textContent = '선택된 파일 없음';
        }
    });

    fileButton.addEventListener('click', function (event) {
        event.stopPropagation();
        event.preventDefault();

        console.log("File button clicked");
        chooseFile.click();
    });
    
    retouchFile.addEventListener('change', function (event) {
        event.stopPropagation();
        event.preventDefault();        

        selectedFile = retouchFile.files && retouchFile.files.length > 0 ? retouchFile.files[0] : null;

		console.log(retouchFile.files[0]);

        if (selectedFile) {
            fileNameDisplay.textContent = selectedFile.name;
        } else {
            fileNameDisplay.textContent = '선택된 파일 없음';
        }
    });

    fileButton.addEventListener('click', function (event) {
        event.stopPropagation();
        event.preventDefault();

        console.log("File button clicked");
//        retouchFile.click();
    });

    imgSelectButton.addEventListener('click', function (event) {
        event.stopPropagation();
        event.preventDefault();

        console.log("Image select button clicked");
        if (selectedFile) {
            displayImagePreview(selectedFile);
        } else if (imgURLInput.value.trim() !== '') {
            displayImagePreview(imgURLInput.value.trim());
        } else {
            alert("파일을 먼저 선택하거나 이미지 URL을 입력해주세요.");
        }
    });
    
    imgRetouchButton.addEventListener('click', function (event) {
        event.stopPropagation();
        event.preventDefault();

        console.log("Image retouch button clicked");
        if (selectedFile) {
            displayImagePreview(selectedFile);
        } else if (imgRetouchURLInput.value.trim() !== '') {
            displayImagePreview(imgRetouchURLInput.value.trim());
        } else {
            alert("파일을 먼저 선택하거나 이미지 URL을 입력해주세요.");
        }
    });

    // 파일 또는 URL을 전달받아 이미지 미리보기를 화면에 표시

    function displayImagePreview(fileOrUrl) {
        if (typeof fileOrUrl === 'string' || fileOrUrl instanceof String) {
            // URL 이미지를 표시
            img_preview.innerHTML = '';
            const imgPreview = document.createElement('img');
            imgPreview.src = fileOrUrl;
            img_preview.appendChild(imgPreview);
        } else {
            // 파일을 읽어와서 이미지를 표시
            const reader = new FileReader();
            reader.readAsDataURL(fileOrUrl);
            reader.onload = function (event) {
                img_preview.innerHTML = '';
                const imgPreview = document.createElement('img');
                imgPreview.src = event.target.result;
                img_preview.appendChild(imgPreview);
            };
        }
    }
    
}


