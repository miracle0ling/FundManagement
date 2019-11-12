<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>创新楼经费报销系统</title>

    <meta name="description" content="Common form elements and layouts" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/logo/favicon.ico" type="image/x-icon" />
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.custom.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/chosen.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-datepicker3.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-timepicker.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/daterangepicker.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-datetimepicker.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-colorpicker.min.css" />

    <!-- text fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts.googleapis.com.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-part2.min.css"
          class="ace-main-stylesheet"/>
    <![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-ie.min.css"/>
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="${pageContext.request.contextPath}/assets/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="${pageContext.request.contextPath}/assets/js/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/respond.min.js"></script>
    <![endif]-->
</head>


<body class="no-skin">
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <div id="navbar" class="navbar navbar-default          ace-save-state">
        <div class="navbar-container ace-save-state" id="navbar-container">
            <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
                <span class="sr-only">Toggle sidebar</span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>
            </button>

            <div class="navbar-header pull-left">
                <a href="./index.html" class="navbar-brand">
                    <small>
                        <i class="fa fa-leaf"></i>
                        创新楼经费报销系统
                    </small>
                </a>
            </div>
            <div class="navbar-buttons navbar-header pull-right" role="navigation">
                <ul class="nav ace-nav" style="text-align: right;">
                    <li class="light-blue dropdown-modal">
                        <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                            <img class="nav-user-photo" src="${pageContext.request.contextPath}/assets/images/avatars/用户1.png" alt="User's Photo" />
                            <span class="user-info">
                                <small>Welcome,</small>
                                ${student.sname}
                            </span>

                            <i class="ace-icon fa fa-caret-down"></i>
                        </a>

                        <ul
                            class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                            <li>
                                <a href="./passwordChange">
                                    <i class="ace-icon fa fa-cog"></i>
                                    修改密码
                                </a>
                            </li>

<%--                            <li>--%>
<%--                                <a href="./userInfo">--%>
<%--                                    <i class="ace-icon fa fa-user"></i>--%>
<%--                                    个人详情--%>
<%--                                </a>--%>
<%--                            </li>--%>

                            <li class="divider"></li>

                            <li>
                                <a href="./logout">
                                    <i class="ace-icon fa fa-power-off"></i>
                                    退出
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>

        </div><!-- /.navbar-container -->
    </div>

    <div class="main-container ace-save-state" id="main-container">
        <script type="text/javascript">
            try {
                ace.settings.loadState('main-container')
            } catch (e) {
            }
        </script>

        <div id="sidebar" class="sidebar                  responsive                    ace-save-state">
            <script type="text/javascript">
                try {
                    ace.settings.loadState('sidebar')
                } catch (e) {
                }
            </script>


            <ul class="nav nav-list">
                <li class="active">
                    <a href="./notice">
                        <i class="menu-icon fa fa-newspaper-o"></i>
                        <span class="menu-text"> 通知公告 </span>
                    </a>

                    <b class="arrow"></b>
                </li>

                <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-list"></i>
                        <span class="menu-text">
                            经费手册
                        </span>

                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">

                        <li class="">
                            <a href="./projectInfo">
                                <i class="menu-icon fa fa-caret-right"></i>
                                大创项目
                            </a>

                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="./studioInfo">
                                <i class="menu-icon fa fa-caret-right"></i>
                                工作室
                            </a>

                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="./">
                                <i class="menu-icon fa fa-caret-right"></i>
                                竞赛
                            </a>

                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="./userInfo">
                                <i class="menu-icon fa fa-caret-right"></i>
                                其他
                            </a>

                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>

                <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-pencil-square-o"></i>
                        <span class="menu-text"> 报销管理 </span>

                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">
                        <li class="">
                            <a href="./application">
                                <i class="menu-icon fa fa-caret-right"></i>
                                报销表单
                            </a>

                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="./churuku">
                                <i class="menu-icon fa fa-caret-right"></i>
                                出入库单
                            </a>

                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>
            </ul>

            <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state"
                    data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
            </div>
        </div>

        <div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="#">首页</a>
                        </li>

                        <li>
                            <a href="#">报销管理</a>
                        </li>
                        <li class="active">报销表单</li>
                    </ul><!-- /.breadcrumb -->

                </div>

                <div class="page-content">

                    <div class="page-header">
                        <h1>
                            报销表单
                        </h1>

                    </div><!-- /.page-header -->

                </div>
                <p style="height: 40px"></p>
                <div align="center">
                <form class="form-inline" action="${pageContext.request.contextPath}/updateapplication" method="post">
                    <div class="form-group">
                        <label for="exampleInputName1">报销类别</label>
                        <input type="text" class="form-control" name="leibie" value="${bill.leibie}" style="margin-left: 40px">
                    </div>
                    <p style="height: 20px"></p>
                    <c:if test="${bill.baoxiao=='有'}">
                    <div class="form-group">
                        <label for="exampleInputName">凭据内容</label>
                        <input type="text" readonly="readonly" class="form-control" name="tname" value="${bill.tname}" style="margin-left: 40px">
                    </div>
                    <p style="height: 20px"></p>
                    </c:if>
                    <div class="form-group">
                        <label for="exampleInputName2">经费科目</label>
                        <input type="text" class="form-control" name="type" value="${bill.type}" style="margin-left: 40px">
                    </div>
                    <p style="height: 20px"></p>
                    <div class="form-group">
                        <label for="exampleInputName2">金额</label>

                        <input type="text" class="form-control" name="amoney" value="${bill.amoney}" style="margin-left: 40px">
                    </div>
                    <p style="height: 20px"></p>
                    <div class="form-group">
                        <label for="exampleInputName2">报销人</label>
                        <input type="text" class="form-control" name="people" value="${bill.people}" style="margin-left: 40px">
                    </div>
                    <p style="height: 20px"></p>
                    <div class="form-group">
                        <label for="exampleInputName2">电话</label>
                        <input type="text" class="form-control" name="tel" value="${bill.tel}" style="margin-left: 40px">
                    </div>
                    <p style="height: 20px"></p>
                    <button type="button" class="btn btn-success"><a href="./application">返回</a></button>
                    <button type="submit" class="btn btn-primary" style="margin-left: 40px">提交</button>
                </form>
                </div>
            </div>
        </div><!-- /.main-content -->
    </div><!-- /.main-container -->
    <!-- basic scripts -->

    <!--[if !IE]> -->
    <script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.4.min.js"></script>

    <!-- <![endif]-->

    <!--[if IE]>
<script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
    <script type="text/javascript">
        if ('ontouchstart' in document.documentElement) document.write("<script src='${pageContext.request.contextPath}/assets/js/jquery.mobile.custom.min.js'>" + "<" + "/script>");
    </script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

    <!-- page specific plugin scripts -->

    <!--[if lte IE 8]>
<script src="${pageContext.request.contextPath}/assets/js/excanvas.min.js"></script>
<![endif]-->
    <script src="${pageContext.request.contextPath}/assets/js/jquery-ui.custom.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.ui.touch-punch.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/chosen.jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/spinbox.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap-datepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap-timepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/daterangepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap-datetimepicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap-colorpicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.knob.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/autosize.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.inputlimiter.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.maskedinput.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/bootstrap-tag.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/jquery.validate.min.js"></script>

    <!-- ace scripts -->
    <script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/calendar/WdatePicker.js"></script>

    <!-- inline scripts related to this page -->
    <script type="text/javascript">
        function checknum(value) {
            var Regx = /^[0-9]*$/;
            if (Regx.test(value)) {
                return true;
            }
            else {
                return false;
            }
        }

        function validAttendcount() {
            var obj = document.getElementById("form-field-1");
            var attendcount = obj.value;
            if (!checknum(attendcount)) {
                document.getElementById("errorAttendcount").innerHTML = "<font size='-1' color='red'>人数必须为纯数字且为整数</font>";
                return false;
            } else if (attendcount > 50) {
                document.getElementById("errorAttendcount").innerHTML = "<font size='-1' color='red'>据规定，人数不能超过50人</font>";
                return false;
            } else {
                document.getElementById("errorAttendcount").innerHTML = "<font size='-1'></font>";
                return true;
            }
        }

        function validStelephone() {
            var obj = document.getElementById("form-field-tags-1");
            var stelephone = obj.value;
            if (stelephone.length != 11 || !checknum(stelephone)) {
                document.getElementById("errorStelephone").innerHTML = "<font size='-1' color='red'>手机号必须为11位纯数字</font>";
                return false;
            } else {
                document.getElementById("errorStelephone").innerHTML = "<font size='-1'></font>";
                return true;
            }
        }

        function validThemeLength() {
            var obj = document.getElementById("form-field-tags");
            var theme = obj.value;
            if (theme.length <= 5) {
                document.getElementById("errorTheme").innerHTML = "<font size='-1' color='red'>主题应大于5个字符！</font>";
                return false;
            } else {
                document.getElementById("errorTheme").innerHTML = "<font size='-1'></font>";
                return true;
            }
        }

        function validTtelephone() {
            var obj = document.getElementById("form-field-tags-2");
            var ttelephone = obj.value;
            if (ttelephone.length != 11 || !checknum(ttelephone)) {
                document.getElementById("errorTtelephone").innerHTML = "<font size='-1' color='red'>手机号必须为11位纯数字</font>";
                return false;
            } else {
                document.getElementById("errorTtelephone").innerHTML = "<font size='-1'></font>";
                return true;
            }
        }

        function validDetails() {
            var obj = document.getElementById("form-field-tags-3");
            var details = obj.value;
            if (details.length < 50 || details.length > 150) {
                document.getElementById("errorDetails").innerHTML = "<font size='-1' color='red'>描述字数必须在50到150字之间</font>";
                return false;
            } else {
                document.getElementById("errorDetails").innerHTML = "<font size='-1'></font>";
                return true;
            }
        }

        function validAll() {
            return validAttendcount() && validTtelephone() && validStelephone() && validThemeLength() && validDetails();
        }
    </script>

    <script type="text/javascript">
        var html;
        var now = new Date();
        var hours;
        var end1;
        var end2;
        $('#startTime').bind('change', function () {
            $("#endTime").html("");

            var option1 = $("#startTime option:selected");//获取当前选中项
            var startTime = option1.text();
            hours = parseInt(startTime.substring(0, 2));
            end1 = hours + 1;
            end2 = hours + 2;
            var startdate = document.getElementById("datepicker").value;
            if (startdate != "") {

                var chosenStarttime = new Date(startdate + " " + startTime + ":00");
            }

            if (chosenStarttime <= now) {
                html = "";
            } else {
                if (end1.toString().length == 1) {
                    end1 = "0" + end1 + ":00";
                } else
                    end1 = end1 + ":00";
                if (end2.toString().length == 1) {
                    end2 = "0" + end2 + ":00";
                } else
                    end2 = end2 + ":00";

                if (startTime == "20:00") {
                    html = "<option value='" + end1 + "'>" + end1 + "</option>";
                }
                else {
                    html = "<option value='" + end1 + "'>" + end1 + "</option>";
                    html += "<option value='" + end2 + "'>" + end2 + "</option>";
                }
            }
            $("#endTime").append(html);
            /*var option2=$("#endTime option:selected");
            var endTime=option2.text();*/
        })

        function cDayFunc(dp) {
            $("#endTime").html("");
            var year = $dp.cal.newdate.y;
            var month = $dp.cal.newdate.M;
            var day = $dp.cal.newdate.d;
            var option1 = $("#startTime option:selected");//获取当前选中项
            var startTime = option1.text();

            hours = parseInt(startTime.substring(0, 2));
            end1 = hours + 1;
            end2 = hours + 2;

            var startdate1 = year + "-" + month + "-" + day;
            if (startdate1 != "") {
                var chosenStarttime = new Date(startdate1 + " " + startTime + ":00");
            }
            if (chosenStarttime <= now) {
                html = "";
                $("#endTime").append(html);
            } else {
                if (end1.toString().length == 1) {
                    end1 = "0" + end1 + ":00";
                } else
                    end1 = end1 + ":00";
                if (end2.toString().length == 1) {
                    end2 = "0" + end2 + ":00";
                } else
                    end2 = end2 + ":00";

                if (startTime == "20:00") {
                    html = "<option value='" + end1 + "'>" + end1 + "</option>";
                }
                else {
                    html = "<option value='" + end1 + "'>" + end1 + "</option>";
                    html += "<option value='" + end2 + "'>" + end2 + "</option>";
                }
            }
            $("#endTime").append(html);
        }
    </script>


    <script type="text/javascript">
        jQuery(function ($) {
            $('#id-disable-check').on('click', function () {
                var inp = $('#form-input-readonly').get(0);
                if (inp.hasAttribute('disabled')) {
                    inp.setAttribute('readonly', 'true');
                    inp.removeAttribute('disabled');
                    inp.value = "This text field is readonly!";
                }
                else {
                    inp.setAttribute('disabled', 'disabled');
                    inp.removeAttribute('readonly');
                    inp.value = "This text field is disabled!";
                }
            });


            if (!ace.vars['touch']) {
                $('.chosen-select').chosen({ allow_single_deselect: true });
                //resize the chosen on window resize

                $(window)
                    .off('resize.chosen')
                    .on('resize.chosen', function () {
                        $('.chosen-select').each(function () {
                            var $this = $(this);
                            $this.next().css({ 'width': $this.parent().width() });
                        })
                    }).trigger('resize.chosen');
                //resize chosen on sidebar collapse/expand
                $(document).on('settings.ace.chosen', function (e, event_name, event_val) {
                    if (event_name != 'sidebar_collapsed') return;
                    $('.chosen-select').each(function () {
                        var $this = $(this);
                        $this.next().css({ 'width': $this.parent().width() });
                    })
                });


                $('#chosen-multiple-style .btn').on('click', function (e) {
                    var target = $(this).find('input[type=radio]');
                    var which = parseInt(target.val());
                    if (which == 2) $('#form-field-select-4').addClass('tag-input-style');
                    else $('#form-field-select-4').removeClass('tag-input-style');
                });
            }


            $('[data-rel=tooltip]').tooltip({ container: 'body' });
            $('[data-rel=popover]').popover({ container: 'body' });

            autosize($('textarea[class*=autosize]'));

            $('textarea.limited').inputlimiter({
                remText: '%n character%s remaining...',
                limitText: 'max allowed : %n.'
            });

            $.mask.definitions['~'] = '[+-]';
            $('.input-mask-date').mask('99/99/9999');
            $('.input-mask-phone').mask('(999) 999-9999');
            $('.input-mask-eyescript').mask('~9.99 ~9.99 999');
            $(".input-mask-product").mask("a*-999-a999", {
                placeholder: " ", completed: function () {
                    alert("You typed the following: " + this.val());
                }
            });


            $("#input-size-slider").css('width', '200px').slider({
                value: 1,
                range: "min",
                min: 1,
                max: 8,
                step: 1,
                slide: function (event, ui) {
                    var sizing = ['', 'input-sm', 'input-lg', 'input-mini', 'input-small', 'input-medium', 'input-large', 'input-xlarge', 'input-xxlarge'];
                    var val = parseInt(ui.value);
                    $('#form-field-4').attr('class', sizing[val]).attr('placeholder', '.' + sizing[val]);
                }
            });

            $("#input-span-slider").slider({
                value: 1,
                range: "min",
                min: 1,
                max: 12,
                step: 1,
                slide: function (event, ui) {
                    var val = parseInt(ui.value);
                    $('#form-field-5').attr('class', 'col-xs-' + val).val('.col-xs-' + val);
                }
            });


            //"jQuery UI Slider"
            //range slider tooltip example
            $("#slider-range").css('height', '200px').slider({
                orientation: "vertical",
                range: true,
                min: 0,
                max: 100,
                values: [17, 67],
                slide: function (event, ui) {
                    var val = ui.values[$(ui.handle).index() - 1] + "";

                    if (!ui.handle.firstChild) {
                        $("<div class='tooltip right in' style='display:none;left:16px;top:-6px;'><div class='tooltip-arrow'></div><div class='tooltip-inner'></div></div>")
                            .prependTo(ui.handle);
                    }
                    $(ui.handle.firstChild).show().children().eq(1).text(val);
                }
            }).find('span.ui-slider-handle').on('blur', function () {
                $(this.firstChild).hide();
            });


            $("#slider-range-max").slider({
                range: "max",
                min: 1,
                max: 10,
                value: 2
            });

            $("#slider-eq > span").css({ width: '90%', 'float': 'left', margin: '15px' }).each(function () {
                // read initial values from markup and remove that
                var value = parseInt($(this).text(), 10);
                $(this).empty().slider({
                    value: value,
                    range: "min",
                    animate: true

                });
            });

            $("#slider-eq > span.ui-slider-purple").slider('disable');//disable third item


            $('#id-input-file-1 , #id-input-file-2').ace_file_input({
                no_file: 'No File ...',
                btn_choose: 'Choose',
                btn_change: 'Change',
                droppable: false,
                onchange: null,
                thumbnail: false //| true | large
                //whitelist:'gif|png|jpg|jpeg'
                //blacklist:'exe|php'
                //onchange:''
                //
            });
            //pre-show a file name, for example a previously selected file
            //$('#id-input-file-1').ace_file_input('show_file_list', ['myfile.txt'])


            $('#id-input-file-3').ace_file_input({
                style: 'well',
                btn_choose: 'Drop files here or click to choose',
                btn_change: null,
                no_icon: 'ace-icon fa fa-cloud-upload',
                droppable: true,
                thumbnail: 'small'//large | fit
                //,icon_remove:null//set null, to hide remove/reset button
                /**,before_change:function(files, dropped) {
                            //Check an example below
                            //or examples/file-upload.html
                            return true;
                        }*/
                /**,before_remove : function() {
                            return true;
                        }*/
                ,
                preview_error: function (filename, error_code) {
                    //name of the file that failed
                    //error_code values
                    //1 = 'FILE_LOAD_FAILED',
                    //2 = 'IMAGE_LOAD_FAILED',
                    //3 = 'THUMBNAIL_FAILED'
                    //alert(error_code);
                }

            }).on('change', function () {
                //console.log($(this).data('ace_input_files'));
                //console.log($(this).data('ace_input_method'));
            });


            //$('#id-input-file-3')
            //.ace_file_input('show_file_list', [
            //{type: 'image', name: 'name of image', path: 'http://path/to/image/for/preview'},
            //{type: 'file', name: 'hello.txt'}
            //]);


            //dynamically change allowed formats by changing allowExt && allowMime function
            $('#id-file-format').removeAttr('checked').on('change', function () {
                var whitelist_ext, whitelist_mime;
                var btn_choose
                var no_icon
                if (this.checked) {
                    btn_choose = "Drop images here or click to choose";
                    no_icon = "ace-icon fa fa-picture-o";

                    whitelist_ext = ["jpeg", "jpg", "png", "gif", "bmp"];
                    whitelist_mime = ["image/jpg", "image/jpeg", "image/png", "image/gif", "image/bmp"];
                }
                else {
                    btn_choose = "Drop files here or click to choose";
                    no_icon = "ace-icon fa fa-cloud-upload";

                    whitelist_ext = null;//all extensions are acceptable
                    whitelist_mime = null;//all mimes are acceptable
                }
                var file_input = $('#id-input-file-3');
                file_input
                    .ace_file_input('update_settings',
                        {
                            'btn_choose': btn_choose,
                            'no_icon': no_icon,
                            'allowExt': whitelist_ext,
                            'allowMime': whitelist_mime
                        })
                file_input.ace_file_input('reset_input');

                file_input
                    .off('file.error.ace')
                    .on('file.error.ace', function (e, info) {
                        //console.log(info.file_count);//number of selected files
                        //console.log(info.invalid_count);//number of invalid files
                        //console.log(info.error_list);//a list of errors in the following format

                        //info.error_count['ext']
                        //info.error_count['mime']
                        //info.error_count['size']

                        //info.error_list['ext']  = [list of file names with invalid extension]
                        //info.error_list['mime'] = [list of file names with invalid mimetype]
                        //info.error_list['size'] = [list of file names with invalid size]


                        /**
                         if( !info.dropped ) {
                                //perhapse reset file field if files have been selected, and there are invalid files among them
                                //when files are dropped, only valid files will be added to our file array
                                e.preventDefault();//it will rest input
                            }
                         */


                        //if files have been selected (not dropped), you can choose to reset input
                        //because browser keeps all selected files anyway and this cannot be changed
                        //we can only reset file field to become empty again
                        //on any case you still should check files with your server side script
                        //because any arbitrary file can be uploaded by user and it's not safe to rely on browser-side measures
                    });


                /**
                 file_input
                 .off('file.preview.ace')
                 .on('file.preview.ace', function(e, info) {
                            console.log(info.file.width);
                            console.log(info.file.height);
                            e.preventDefault();//to prevent preview
                        });
                 */

            });

            $('#spinner1').ace_spinner({
                value: 0,
                min: 0,
                max: 200,
                step: 10,
                btn_up_class: 'btn-info',
                btn_down_class: 'btn-info'
            })
                .closest('.ace-spinner')
                .on('changed.fu.spinbox', function () {
                    //console.log($('#spinner1').val())
                });
            $('#spinner2').ace_spinner({
                value: 0,
                min: 0,
                max: 10000,
                step: 100,
                touch_spinner: true,
                icon_up: 'ace-icon fa fa-caret-up bigger-110',
                icon_down: 'ace-icon fa fa-caret-down bigger-110'
            });
            $('#spinner3').ace_spinner({
                value: 0,
                min: -100,
                max: 100,
                step: 10,
                on_sides: true,
                icon_up: 'ace-icon fa fa-plus bigger-110',
                icon_down: 'ace-icon fa fa-minus bigger-110',
                btn_up_class: 'btn-success',
                btn_down_class: 'btn-danger'
            });
            $('#spinner4').ace_spinner({
                value: 0,
                min: -100,
                max: 100,
                step: 10,
                on_sides: true,
                icon_up: 'ace-icon fa fa-plus',
                icon_down: 'ace-icon fa fa-minus',
                btn_up_class: 'btn-purple',
                btn_down_class: 'btn-purple'
            });

            //$('#spinner1').ace_spinner('disable').ace_spinner('value', 11);
            //or
            //$('#spinner1').closest('.ace-spinner').spinner('disable').spinner('enable').spinner('value', 11);//disable, enable or change value
            //$('#spinner1').closest('.ace-spinner').spinner('value', 0);//reset to 0


            //datepicker plugin
            //link
            /*$('.date-picker').datepicker({
                autoclose: true,
                todayHighlight: true
            })
            //show datepicker when clicking on the icon
                .next().on(ace.click_event, function () {
                $(this).prev().focus();
            });
    
            //or change it into a date range picker
            $('.input-daterange').datepicker({autoclose: true});
    
    
            //to translate the daterange picker, please copy the "examples/daterange-fr.js" contents here before initialization
            $('input[name=date-range-picker]').daterangepicker({
                'applyClass': 'btn-sm btn-success',
                'cancelClass': 'btn-sm btn-default',
                locale: {
                    applyLabel: 'Apply',
                    cancelLabel: 'Cancel',
                }
            })
                .prev().on(ace.click_event, function () {
                $(this).next().focus();
            });*/


            $('#timepicker1').timepicker({
                minuteStep: 1,
                showSeconds: true,
                showMeridian: false,
                disableFocus: true,
                icons: {
                    up: 'fa fa-chevron-up',
                    down: 'fa fa-chevron-down'
                }
            }).on('focus', function () {
                $('#timepicker1').timepicker('showWidget');
            }).next().on(ace.click_event, function () {
                $(this).prev().focus();
            });


            if (!ace.vars['old_ie']) $('#date-timepicker1').datetimepicker({
                //format: 'MM/DD/YYYY h:mm:ss A',//use this option to display seconds
                icons: {
                    time: 'fa fa-clock-o',
                    date: 'fa fa-calendar',
                    up: 'fa fa-chevron-up',
                    down: 'fa fa-chevron-down',
                    previous: 'fa fa-chevron-left',
                    next: 'fa fa-chevron-right',
                    today: 'fa fa-arrows ',
                    clear: 'fa fa-trash',
                    close: 'fa fa-times'
                }
            }).next().on(ace.click_event, function () {
                $(this).prev().focus();
            });


            $('#colorpicker1').colorpicker();
            //$('.colorpicker').last().css('z-index', 2000);//if colorpicker is inside a modal, its z-index should be higher than modal'safe

            $('#simple-colorpicker-1').ace_colorpicker();
            //$('#simple-colorpicker-1').ace_colorpicker('pick', 2);//select 2nd color
            //$('#simple-colorpicker-1').ace_colorpicker('pick', '#fbe983');//select #fbe983 color
            //var picker = $('#simple-colorpicker-1').data('ace_colorpicker')
            //picker.pick('red', true);//insert the color if it doesn't exist


            $(".knob").knob();


            /* var tag_input = $('#form-field-tags');
             try {
                 tag_input.tag(
                     {
                         placeholder: tag_input.attr('placeholder'),
                         //enable typeahead by specifying the source array
                         source: ace.vars['US_STATES'],//defined in ace.js >> ace.enable_search_ahead
                         /!**
                          //or fetch data from database, fetch those that match "query"
                          source: function(query, process) {
                               $.ajax({url: 'remote_source.php?q='+encodeURIComponent(query)})
                               .done(function(result_items){
                                 process(result_items);
                               });
                             }
                          *!/
                     }
                 )
    
                 var index = $tag_obj.inValues('some tag');
                 $tag_obj.remove(index);
             }
             catch (e) {
                 //display a textarea for old IE, because it doesn't support this plugin or another one I tried!
                 tag_input.after('<textarea id="' + tag_input.attr('id') + '" name="' + tag_input.attr('name') + '" rows="3">' + tag_input.val() + '</textarea>').remove();
                 //autosize($('#form-field-tags'));
             }*/


            /////////
            $('#modal-form input[type=file]').ace_file_input({
                style: 'well',
                btn_choose: 'Drop files here or click to choose',
                btn_change: null,
                no_icon: 'ace-icon fa fa-cloud-upload',
                droppable: true,
                thumbnail: 'large'
            })

            //chosen plugin inside a modal will have a zero width because the select element is originally hidden
            //and its width cannot be determined.
            //so we set the width after modal is show
            $('#modal-form').on('shown.bs.modal', function () {
                if (!ace.vars['touch']) {
                    $(this).find('.chosen-container').each(function () {
                        $(this).find('a:first-child').css('width', '210px');
                        $(this).find('.chosen-drop').css('width', '210px');
                        $(this).find('.chosen-search input').css('width', '200px');
                    });
                }
            })
            /**
             //or you can activate the chosen plugin after modal is shown
             //this way select element becomes visible with dimensions and chosen works as expected
             $('#modal-form').on('shown', function () {
                        $(this).find('.modal-chosen').chosen();
                    })
             */


        });

        $("#form-field-select-1").val("${cid}");
        $("#form-field-select-9").val("${faculty}");

        $("#datepicker").ready(function () {
            $("#startdate").val("${startdate}");
        });

        $("#startTime").ready(function () {
            if ($("#startTime").val("${starttime}") == null) {
                $("#startTime").val("08:00");
            } else {
                $("#startTime").val("${starttime}");
            }
        });

        $("#startTime").ready(function () {
            $("#endTime").val("${endtime}");
        });
    </script>
</body>

</html>