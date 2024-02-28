const hover = document.querySelectorAll('a.hover');
const menuBar = document.querySelector('.menu-bar');
const nav = document.querySelector('nav');
const wrap = document.querySelector('.wrap');

// 모바일 스크립트 코드
const hamburgerMenu = document.querySelector('.hamburger-menu');
const myPage = document.querySelector('#myPage');

hamburgerMenu.addEventListener('click', function() {
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

const section = document.querySelector('section');
section.addEventListener("click", function() {
	hideMenuBar();
})

let isHovered = false;

hover.forEach(button => {
	button.addEventListener('mouseover', () => {
		showMenuBar();
		isHovered = true;
	});
});

wrap.addEventListener("mouseleave", function() {
	if (!isHovered) {
		hideMenuBar();
	}
});

menuBar.addEventListener("mouseenter", function() {
	isHovered = true;
});

menuBar.addEventListener("mouseleave", function() {
	hideMenuBar();
});

function showMenuBar() {
	nav.classList.add('active');
}

function hideMenuBar() {
	nav.classList.remove('active');
}

hover.forEach(link => {
	link.addEventListener("click", function(event) {
		let myPage = document.querySelector("#myPage");
		let menuBar = document.querySelector(".menu-bar");
		let mainPage = document.querySelector(".wrap");
		let companyLogo = document.querySelector("#workerLogo");

		let ulLi = document.querySelectorAll(".menu-bar-content ul li");


		event.preventDefault();
		if (nav.classList.contains('active') && window.matchMedia("(max-width: 430px)").matches) {
			nav.style.height = `${section.offsetHeight}px`

			for (let i = 0; i < ulLi.length; i++) {
				ulLi[i].style.padding = '7px';

			}
			menuBar.prepend(myPage);
		}
	});
});

function listEmployees() {
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/mes_project/account?action=list', true);
	xhr.onload = function() {
		if (this.status == 200) {
			var account = JSON.parse(this.responseText);
			var tableBody = document.querySelector('.Staff_list tbody');
			console.log('서버에서 받은 직원 목록:', account);
			tableBody.innerHTML = ''; // 기존 목록을 초기화

			account.forEach(function(account) {
				var row = `<tr>
                    <td>${account.empno}</td>
                    <td>${account.name}</td>
                    <td>${account.userId}</td>
                    <td>
                        <select onchange="updateRole(this, ${account.empno})">
                            <option value="ADMIN" ${account.role === 'ADMIN' ? 'selected' : ''}>ADMIN</option>
                            <option value="WORKER" ${account.role === 'WORKER' ? 'selected' : ''}>WORKER</option>
                            <option value="UNDEFINED" ${account.role === 'UNDEFINED' ? 'selected' : ''}>UNDEFINED</option>
                        </select>
                    </td>
                </tr>`;
				tableBody.innerHTML += row; // 새로운 행 추가
			});
		} else {
			alert('직원 목록을 불러오는 데 실패했습니다.');
		}
	};
	xhr.send();
}

function updateRole(selectElement, empno) {
    var newRole = selectElement.value;
    // 여기서 POST 요청을 보내 서버에서 권한을 
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/mes_project/account?action=updateRole', true);
    xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
    xhr.onload = function() {
        if (this.status == 200) {
            alert('권한이 업데이트되었습니다.');
        } else {
            alert('권한 업데이트에 실패했습니다.');
        }
    };
    xhr.send('empno=' + empno + '&newRole=' + newRole);
}

document.addEventListener('DOMContentLoaded', function() {
	listEmployees(); // 페이지 로드 시 직원 목록을 불러옵니다.
});

