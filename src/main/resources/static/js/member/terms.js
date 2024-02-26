
    function checkForm() {
        var checkbox1 = $("#check_terms1");
        var checkbox2 = $("#check_terms2");

        if (checkbox1.prop("checked") && checkbox2.prop("checked")) {
            // 모든 약관이 체크되었을 때 submit 버튼을 눌러 다음 화면으로 이동
            // 여기에 submit 버튼을 눌렀을 때의 동작을 추가
            // 예: $("#myForm").submit();
            alert("약관에 모두 동의하셨습니다. 다음 화면으로 이동합니다.");
        } else {
            // 체크되지 않은 약관명을 출력하여 사용자에게 안내
            var errorMessage = "약관에 동의해야 합니다";
            if (!checkbox1.prop("checked")) {
                errorMessage += "\n- 일반 회원";
            }
            if (!checkbox2.prop("checked")) {
                errorMessage += "\n- 14세 이상 이용자";
            }
            alert(errorMessage);
        }
    };

    $("#submit_btn").click(checkForm);
