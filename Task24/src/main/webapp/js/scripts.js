$(document).ready(function() {


//    $(".sub").click( function() {
//	 alert('Изменения сохранены');
//	});


    // jQuery datepicker
    $( "#tabs" ).tabs();
    $( "#datepicker" ).datepicker({
        changeMonth: true,
        yearRange: "1950:2005",
        changeYear: true,
        defaultDate: new Date(1994, 00, 01)
    });

	$.datepicker.regional['ru'] = {
		closeText: 'Закрыть',
		prevText: '&#x3C;Пред',
		nextText: 'След&#x3E;',
		currentText: 'Сегодня',
		monthNames: ['Январь','Февраль','Март','Апрель','Май','Июнь',
		'Июль','Август','Сентябрь','Октябрь','Ноябрь','Декабрь'],
		monthNamesShort: ['Янв','Фев','Мар','Апр','Май','Июн',
		'Июл','Авг','Сен','Окт','Ноя','Дек'],
		dayNames: ['воскресенье','понедельник','вторник','среда','четверг','пятница','суббота'],
		dayNamesShort: ['вск','пнд','втр','срд','чтв','птн','сбт'],
		dayNamesMin: ['Вс','Пн','Вт','Ср','Чт','Пт','Сб'],
		weekHeader: 'Нед',
		dateFormat: 'dd.mm.yy',
		firstDay: 1,
		isRTL: false,
		showMonthAfterYear: false,
		yearSuffix: ''};
	$.datepicker.setDefaults($.datepicker.regional['ru']);


    // jQuery validation

    jQuery.validator.addMethod("dateITA", function(value, element) {
        var check = false;
        var re = /^\d{1,2}\.\d{1,2}\.\d{4}$/;
        if( re.test(value)) {
            var adata = value.split('.');
            var gg = parseInt(adata[0],10);
            var mm = parseInt(adata[1],10);
            var aaaa = parseInt(adata[2],10);
            var xdata = new Date(aaaa,mm-1,gg);
            if ( ( xdata.getFullYear() === aaaa ) && ( xdata.getMonth() === mm - 1 ) && ( xdata.getDate() === gg ) ){
                check = true;
            } else {
                check = false;
            }
        } else {
            check = false;
        }
        return this.optional(element) || check;
    });



    $("#signup_form").validate({
        rules: {
            name:"required",
            lastname: "required",
            birthday: {
                required: true,
                dateITA: true
            },
            group: "required",
            laboratory: "required",
            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 5
            },
            confirm_password: {
                required: true,
                equalTo: "#password"
            }
        },
        messages: {
            name: {
                required: "Введите свое имя"
            },
            lastname: {
                required: "Введите свою фамилию"
            },
            birthday: {
                required: "Введите дату рождения",
                dateITA: "Формат: ДД.ММ.ГГГГ"
            },
            group: {
                required: "Введите номер группы"
            },
            password: {
                required: "Введите пароль",
                minlength: "Пароль должен состоять минимум из 5 символов"
            },
            confirm_password: {
                required: "Подтвердите пароль",
                equalTo: "Пароли не совпадают"
            },
            email: "Введите правильный email"
        }
    });

    $("#edit_form1").validate({
        rules: {
            name:"required",
            lastname: "required",
            group: "required",
            birthday: {
                required: true,
                dateITA: true
            },
            labs: "required"
        },
        messages: {
            firstname: {
                required: "Введите свое имя"
            },
            lastname: {
                required: "Введите свою фамилию"
            },
            birthday: {
                required: "Введите дату рождения",
                dateITA: "Формат: ДД.ММ.ГГГГ"
            },
            group: {
                required: "Введите номер группы"
            }
        },
        invalidHandler: function() { alert("заполните форму корректными данными!"); },
        submitHandler: function(form) {
            alert("Изменения сохранены!");
            form.submit()
        }
    });

    $("#edit_form2").validate({
        rules: {
            gmail: "email",
            vk: "url",
            twitter: "url",
            instagram: "url",
            linkedin: "url"
        },
        invalidHandler: function() { alert("заполните форму корректными данными!"); },
        submitHandler: function(form) {
            alert("Изменения сохранены!");
            form.submit()
        }
    });
});
