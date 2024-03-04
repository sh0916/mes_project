/**
 * 
 */
// 검색 메소드
document.addEventListener("DOMContentLoaded", function() {
	document.getElementById("SearchEmpNo").focus();
});

function searchEmployee() {
	var empno = document.getElementById('SearchEmpNo').value;
	var searchMessage = document.querySelector('.searchMessage');

	if (!empno) {
		searchMessage.innerHTML = '<span style="color: red; font-size: 13px;">※직원 번호를 입력해주세요.</span>';
		return;
	}

	// AJAX 요청 생성
	var xhr = new XMLHttpRequest();
	xhr.open('GET', '/mes_project/signup?action=search&empno=' + encodeURIComponent(empno), true);
	xhr.onload = function() {
		if (this.status == 200) {
			var response = JSON.parse(this.responseText);

			// 서버에서 직원 정보가 없는 경우 오류 메시지 처리
			if (response.success === false) {
				searchMessage.innerHTML = '<span style="color: red; font-size: 13px;">※' + response.message + '</span>';
				return;
			}

			// 받은 데이터를 모달창의 입력 필드에 설정
			document.getElementById('name').value = response.name || '';
		} else {
			searchMessage.innerHTML = '<span style="color: red; font-size: 13px;">※직원 정보를 조회하는데 실패했습니다.</span>';
		}
	};
	xhr.onerror = function() {
		searchMessage.innerHTML = '<span style="color: red; font-size: 13px;">※직원 정보 조회 요청에 실패했습니다.</span>';
	};
	xhr.send();
}

// 계정 등록
function updateAccount() {
	var empno = document.getElementById('SearchEmpNo').value.trim();
	var userId = document.getElementById('userId').value.trim();
	var password = document.getElementById('password').value.trim();
	var email = document.getElementById('email-input').value.trim();
	var tel = document.getElementById('tel').value.trim();

	// 폼체크
	var updateMessage = document.getElementById('updateMessage');
	var idError = document.querySelector('.idLength');
	var passError = document.querySelector('.passLength');
	var mailError = document.querySelector('.mailCheck');
	var telError = document.querySelector('.telCheck');
	var searchMessage = document.querySelector('.searchMessage');

	[idError, passError, mailError, telError, searchMessage].forEach(el => el.innerHTML = '');

	// 유효성 검사
	if (!empno) {
		searchMessage.innerHTML = '<span style="color: red; font-size: 13px;">※먼저 직원번호를 조회 해주세요.</span>';
		document.getElementById('SearchEmpNo').focus();
		return;
	}
	if (!userId) {
		idError.innerHTML = '※아이디를 입력해주세요.';
		document.getElementById('userId').focus();
		return;
	}
	if (userId.length < 5 || userId.length > 20) {
		idError.innerHTML = '<span style="color: red; font-size: 13px;">※아이디는 5자 이상, 20자 이하로 해주세요.</span>';
		document.getElementById('userId').focus();
		return;
	}

	if (!password) {
		passError.innerHTML = '※비밀번호를 입력해주세요.';
		document.getElementById('password').focus();
		return;
	}
	if (password.length < 8 || password.length > 20) {
		passError.innerHTML = '<span style="color: red; font-size: 13px;">※비밀번호는 8자 이상, 20자 이하로 해주세요.</span>';
		document.getElementById('password').focus();
		return;
	}

	// 이메일 형식 검증
	var emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	if (!emailPattern.test(email)) {
		mailError.innerHTML = "유효하지 않은 이메일 형식입니다.";
		document.getElementById('email-input').focus();
		return;
	}

	// 전화번호 형식 검증
	var telPattern = /^\d{2,3}-\d{3,4}-\d{4}$/;
	if (!telPattern.test(tel)) {
		telError.innerHTML = "유효하지 않은 전화번호 형식입니다. (예: 010-1234-5678)";
		document.getElementById('tel').focus();
		return;
	}

	var formData = JSON.stringify({
		action: "update",
		empno: empno,
		userId: userId,
		password: password,
		email: email,
		tel: tel,
	});

	var xhr = new XMLHttpRequest();
	xhr.open("POST", "/mes_project/signup?action=update", true);
	xhr.setRequestHeader("Content-Type", "application/json");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			var response = JSON.parse(this.responseText);
			if (response.success === true) {
				window.location.href = "/mes_project/login?message=" + encodeURIComponent(response.message);
			} else {
				updateMessage.innerHTML = '<span style="color: red; font-size: 13px;">※' + response.message + '</span>';
			}
		}
	};

	xhr.send(formData);
};

// 이메일 인풋창 예시 선택
document.addEventListener('DOMContentLoaded', function() {
	var emailInput = document.getElementById('email-input');
	var suggestionsPanel = document.getElementById('suggestions');

	var emailDomains = ['gmail.com', 'naver.com', 'daum.net'];

	emailInput.addEventListener('input', function() {
		var inputVal = this.value;
		suggestionsPanel.innerHTML = '';
		if (inputVal.includes('@')) {
			var filteredDomains = emailDomains.filter(function(domain) {
				return domain.startsWith(inputVal.split('@')[1]);
			});

			filteredDomains.forEach(function(domain) {
				var div = document.createElement('div');
				div.innerHTML = inputVal.split('@')[0] + '@' + domain;
				div.addEventListener('click', function() {
					emailInput.value = this.textContent;
					suggestionsPanel.innerHTML = '';
				});
				suggestionsPanel.appendChild(div);
			});
		}
	});
});