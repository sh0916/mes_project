window.addEventListener("load", function () {

//    let id = "admin";
//
//    document.querySelector("#finished-send-button")
//        .addEventListener("click", function () {
//            id = "admin";
//            userCheck(id);
//        });
//    document.querySelector("#defective-send-button")
//        .addEventListener("click", function () {
//            id = "admin";
//            userCheck(id);
//        });
//    document.querySelector("#back-button")
//        .addEventListener("click", function () {
//            id = "user";
//            userCheck(id);
//        });
//
//    sendExecution();
//    sendCancel();

    const hover = document.querySelectorAll('a.hover');
    const menuBar = document.querySelector('.menu-bar');
    const nav = document.querySelector('nav');

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

            let sectionHeight = section.offsetHeight;
            nav.style.height = `${sectionHeight}px`;
        } else {
            workerTitle.appendChild(myPage);
            myPage.style.display = '';
            nav.style.height = '';
        }
    });
    
    const wrap = document.querySelector('.wrap');

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

    const section = document.querySelector('section');
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

//    document.querySelector("#adminTitle").style.display = 'block';
//    document.querySelector("#adminNav").style.display = 'block';
//    document.querySelector(".workerGrade").innerHTML = '작업자<br>';
    // document.querySelector(".workerGrade").innerHTML = '관리자<br>';

    // document.querySelector("#adminTitle").style.display = 'none';
    // document.querySelector("#adminNav").style.display = 'none';

selectDate();

});


function userCheck(id) {

    if (id == "user") {
        document.querySelector("#mainTitle2").style.display = "none";
        document.querySelector("#mainTitle1").style.display = "block";
        document.querySelector(".work-report-content").style.display = "inline-block";
        document.querySelector("#quality-history").style.display = "none";
    } else if (id == "admin") {
        document.querySelector("#mainTitle2").style.display = "block";
        document.querySelector("#mainTitle1").style.display = "none";
        document.querySelector(".work-report-content").style.display = "none";
        document.querySelector("#quality-history").style.display = "block";
    }

};

function sendExecution() {

    const finished_send_button = document.querySelector("#finished-send-button");
    const defective_send_button = document.querySelector("#defective-send-button");
    const finished_line_select = document.querySelector("#finished-line-select-box");
    const defective_line_select = document.querySelector("#defective-line-select-box");

    const entry_table = document.querySelector("#entry-table");
    const main_table = document.querySelector("#main-table");
    const performance_table = document.querySelector("#performance-table");

    finished_send_button.addEventListener("click", function () {

        const finished_select_box = document.querySelector("#finished-select-box");
        const report_count = document.querySelector("#finished-report-count");
        const report_sign = document.querySelector("#finished-report-sign");
        const input_value = report_sign.value;

        let countValue = parseInt(report_count.value);
        if (countValue < 0) {
            alert("음수 설정 불가.");
            report_count.value = "";
            return;
        }

        let target_model;
        if (finished_select_box.value == "entry") {
            target_model = document.querySelector("#entry-table");

        } else if (finished_select_box.value == "main") {
            target_model = document.querySelector("#main-table");

        } else if (finished_select_box.value == "performance") {
            target_model = document.querySelector("#performance-table");

        }

        if (target_model) {

            if (finished_line_select.value == "1") {

                let line_index = target_model.querySelectorAll(".quality-table-cell")[1];
                line_index.innerHTML = `<p><a href="#" class="report-result" data-value="${input_value}">${report_count.value}</a></p>`;
                line_index.querySelector(".report-result")
                    .addEventListener("click", function () {
                        reportPopup(input_value)
                    });

            } else if (finished_line_select.value == "2") {

                let line_index = target_model.querySelectorAll(".quality-table-cell")[3];
                line_index.innerHTML = `<p><a href="#" class="report-result" data-value="${input_value}">${report_count.value}</a></p>`;
                line_index.querySelector(".report-result")
                    .addEventListener("click", function () {
                        reportPopup(input_value)
                    });

            } else if (finished_line_select.value == "3") {

                let line_index = target_model.querySelectorAll(".quality-table-cell")[5];
                line_index.innerHTML = `<p><a href="#" class="report-result" data-value="${input_value}">${report_count.value}</a></p>`;
                line_index.querySelector(".report-result")
                    .addEventListener("click", function () {
                        reportPopup(input_value)
                    });

            }

        }

        finished_line_select.value = "1";
        finished_select_box.value = "1";
        report_count.value = "";
        report_sign.value = "";

    });

    defective_send_button.addEventListener("click", function () {

        const defective_select_box = document.querySelector("#defective-select-box");
        const report_count = document.querySelector("#defective-report-count");
        const report_sign = document.querySelector("#defective-report-sign");
        const input_value = report_sign.value;

        let countValue = parseInt(report_count.value);
        if (countValue < 0) {
            alert("음수 설정 불가.");
            report_count.value = "";
            return;
        }

        console.log("불량");
        let target_model;
        if (defective_select_box.value == "entry") {
            target_model = document.querySelector("#entry-table");

        } else if (defective_select_box.value == "main") {
            target_model = document.querySelector("#main-table");

        } else if (defective_select_box.value == "performance") {
            target_model = document.querySelector("#performance-table");

        }

        if (target_model) {

            if (defective_line_select.value == "1") {

                let line_index = target_model.querySelectorAll(".quality-table-cell")[2];
                line_index.innerHTML = `<p><a href="#" class="report-result" data-value="${input_value}">${report_count.value}</a></p>`;
                line_index.querySelector(".report-result")
                    .addEventListener("click", function () {
                        reportPopup(input_value)
                    });

            } else if (defective_line_select.value == "2") {

                let line_index = target_model.querySelectorAll(".quality-table-cell")[4];
                line_index.innerHTML = `<p><a href="#" class="report-result" data-value="${input_value}">${report_count.value}</a></p>`;
                line_index.querySelector(".report-result")
                    .addEventListener("click", function () {
                        reportPopup(input_value)
                    });

            } else if (defective_line_select.value == "3") {

                let line_index = target_model.querySelectorAll(".quality-table-cell")[6];
                line_index.innerHTML = `<p><a href="#" class="report-result" data-value="${input_value}">${report_count.value}</a></p>`;
                line_index.querySelector(".report-result")
                    .addEventListener("click", function () {
                        reportPopup(input_value)
                    });

            }

        }

        defective_line_select.value = "1";
        defective_select_box.value = "1";
        report_count.value = "";
        report_sign.value = "";

    });

};

function sendCancel() {

    document.querySelector("#finished-cancle-button")
        .addEventListener("click", function () {

            const finished_line_select = document.querySelector("#finished-line-select-box");
            const finished_select_box = document.querySelector("#finished-select-box");
            const report_count = document.querySelector("#finished-report-count");
            const report_sign = document.querySelector("#finished-report-sign");

            finished_line_select.value = "1";
            finished_select_box.value = "1";
            report_count.value = "";
            report_sign.value = "";

        });

    document.querySelector("#defective-cancle-button")
        .addEventListener("click", function () {

            const defective_line_select = document.querySelector("#defective-line-select-box");
            const defective_select_box = document.querySelector("#defective-select-box");
            const report_count = document.querySelector("#defective-report-count");
            const report_sign = document.querySelector("#defective-report-sign");

            defective_line_select.value = "1";
            defective_select_box.value = "1";
            report_count.value = "";
            report_sign.value = "";

        });

};

function reportPopup(input_value) {

    // 팝업과 버튼 요소 가져오기
    const report_popup = document.getElementById("report-popup");
    const closeModalBtn = document.getElementById("closeModalBtn");
    const report_content = document.querySelector(".report-popup-content");
    const report_detail = document.querySelector(".report-detail");

    // 팝업 열기
    report_popup.style.display = "block";
    // 다른 부분의 클릭 이벤트 비활성화
    report_popup.style.pointerEvents = "auto";

    // let data_value = document.querySelector(".report-result").getAttribute("data-value")

    report_detail.innerHTML = "";

    let html = "";
    html = document.createElement("p");
    html.textContent = input_value;
    report_detail.append(html);


    // 팝업 닫기 - "x" 버튼을 클릭했을 때만 작동
    closeModalBtn.addEventListener("click", function () {
        report_popup.style.display = "none";
        // 다른 부분의 클릭 이벤트 재활성화
        report_popup.style.pointerEvents = "none";
    });

    // 팝업 외부를 클릭하여 모달 닫기 방지
    report_popup.addEventListener("click", function (event) {
        event.stopPropagation();
    });

    // 팝업 외부를 클릭하여 모달 닫기 허용
    window.addEventListener("click", function (event) {
        if (event.target == report_popup) {
            report_popup.style.display = "none";
            // 다른 부분의 클릭 이벤트 재활성화
            report_popup.style.pointerEvents = "none";
        }
    });


};

function selectDate() {
	
	document.querySelector("#select_date")
			.addEventListener("change", () => {
		
		console.log(document.querySelector("#select_date").value);
		
		let form = document.createElement("form");
		form.setAttribute("method", "get");
		form.setAttribute("action", "workReport");
		
		let date = document.querySelector("#select_date").value;
		let unclearInput = document.createElement("input");
		unclearInput.setAttribute("type", "text");
		unclearInput.setAttribute("name", "select_date");
		unclearInput.setAttribute("value", date);
		form.appendChild(unclearInput);

		document.body.appendChild(form);
		
		form.submit();
	});
}
