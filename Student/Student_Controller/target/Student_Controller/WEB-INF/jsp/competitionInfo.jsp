<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>信息查询 - 经费管理系统</title>

    <meta name="description" content="Common UI Features &amp; Elements" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/logo/favicon.ico" type="image/x-icon" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.custom.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery.gritter.min.css" />

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
    <style>
        /* some elements used in demo only */
        .spinner-preview {
            width: 100px;
            height: 100px;
            text-align: center;
            margin-top: 60px;
        }

        .dropdown-preview {
            margin: 0 5px;
            display: inline-block;
        }

        .dropdown-preview>.dropdown-menu {
            display: block;
            position: static;
            margin-bottom: 5px;
        }
    </style>

    <!-- ace settings handler -->
    <script src="${pageContext.request.contextPath}/assets/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="${pageContext.request.contextPath}/assets/js/html5shiv.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="no-skin">
    <div id="navbar" class="navbar navbar-default          ace-save-state">
        <div class="navbar-container ace-save-state" id="navbar-container">
            <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
                <span class="sr-only">Toggle sidebar</span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>

                <span class="icon-bar"></span>
            </button>

            <div class="navbar-header pull-left">
                <a href="student/index.html" class="navbar-brand">
                    <small>
                        <i class="fa fa-leaf"></i>
                        经费管理系统
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
                                <a href="student/passwordChange.html">
                                    <i class="ace-icon fa fa-cog"></i>
                                    修改密码
                                </a>
                            </li>

                            <li>
                                <a href="student/userInfo.html">
                                    <i class="ace-icon fa fa-user"></i>
                                    个人详情
                                </a>
                            </li>

                            <li class="divider"></li>

                            <li>
                                <a href="student/logout.html">
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
                            信息查询
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
                            <a href="./personInfo">
                                <i class="menu-icon fa fa-caret-right"></i>
                                个人报销记录
                            </a>

                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>

                <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="menu-icon fa fa-pencil-square-o"></i>
                        <span class="menu-text"> 新建报销 </span>

                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">
                        <li class="">
                            <a href="./application">
                                <i class="menu-icon fa fa-caret-right"></i>
                                普通报销
                            </a>

                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="./travelapply">
                                <i class="menu-icon fa fa-caret-right"></i>
                                差旅报销
                            </a>

                            <b class="arrow"></b>
                        </li>
                        <li class="">
                            <a href="./rentapply">
                                <i class="menu-icon fa fa-caret-right"></i>
                                借款报销
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
                            <a href="#">信息查询</a>
                        </li>
                        <li class="active">竞赛</li>
                    </ul><!-- /.breadcrumb -->
                </div>

                <div class="page-content">

                    <div class="page-header">
                        <h1>
                            竞赛
                        </h1>
                    </div><!-- /.page-header -->

                    <div class="row">
                        <div class="col-xs-12">

                            <div class="hr dotted"></div>

                            <div>
                                <div id="user-profile-1" class="user-profile row">
                                    <div class="col-xs-12 col-sm-3 center">
                                        <div>
                                            <span class="profile-picture">
                                                <img id="avatar" class="editable img-responsive"
                                                    alt="${student.sname}的头像" src="${pageContext.request.contextPath}/assets/images/avatars/用户1.png" />
                                            </span>

                                            <div class="space-4"></div>

                                            <div
                                                class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
                                                <div class="inline position-relative">
                                                    <a href="#" class="user-title-label dropdown-toggle"
                                                        data-toggle="dropdown">
                                                        <span class="white">${student.sname}</span>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="space-6"></div>


                                        <div class="hr hr12 dotted"></div>

                                        <div class="clearfix" style="width: 100%;">
                                            <div class="grid2" style="margin-left: 25%;">
                                                <span class="bigger-175 blue">￥${appCount}</span>

                                                <br />
                                                可用经费
                                            </div>

                                        </div>

                                        <div class="hr hr16 dotted"></div>
                                    </div>

                                    <div class="col-xs-12 col-sm-9">

                                        <div class="space-12"></div>

                                        <div class="profile-user-info profile-user-info-striped">
                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> 竞赛编号</div>

                                                <div class="profile-info-value">
                                                    <span class="editable" id="userid">${student.snum}</span>
                                                </div>
                                            </div>

                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> 竞赛名称</div>

                                                <div class="profile-info-value">
                                                    <span class="editable" id="username">${student.sname}</span>
                                                </div>
                                            </div>

                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> 负责人</div>

                                                <div class="profile-info-value">
                                                    <span class="editable" id="faculty">${student.sfaculty}</span>
                                                </div>
                                            </div>

                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> 总经费</div>

                                                <div class="profile-info-value">
                                                    <span class="editable" id="faculty">${student.sfaculty}</span>
                                                </div>
                                            </div>

                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> 已用经费</div>

                                                <div class="profile-info-value">
                                                    <span class="editable" id="faculty">${student.sfaculty}</span>
                                                </div>
                                            </div>

                                            <div class="profile-info-row">
                                                <div class="profile-info-name"> 可用经费</div>

                                                <div class="profile-info-value">
                                                    <span class="editable" id="faculty">${student.sfaculty}</span>
                                                </div>
                                            </div>

                                            <c:if test="${student.stelphone != null}">
                                                <div class="profile-info-row">
                                                    <div class="profile-info-name"> 联系电话</div>

                                                    <div class="profile-info-value">
                                                        <span class="editable"
                                                            id="telephone">${student.stelphone}</span>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </div>

                                        <div class="space-20"></div>




                                        <div class="space-6"></div>

                                    </div>

                                </div>
                            </div>

                            <!-- PAGE CONTENT ENDS -->
                        </div><!-- /.col -->
                    </div><!-- /.row -->



                    <div class="table-responsive">
                        <table id="dynamic-table" class="table table-striped table-bordered table-hover text-nowrap">
                            <thead>
                                <tr>
                                    <th>
                                        <i class="ace-icon fa fa-clock-o bigger-110 hidden-480"></i> 报销时间
                                    </th>
                                    <th class="hidden-480">报销物品</th>
                                    <th class="hidden-480">类别</th>
                                    <th class="hidden-480">报销人</th>
                                    <th>单价</th>
                                    <th>数量</th>
                                    <th>税率</th>
                                    <th>总额</th>
                                    <th>报销方式</th>
                                    <th>状态</th>
                                    <th>操作</th>
                                </tr>
                            </thead>

                            <tbody>
                                <c:forEach items="${orderList}" var="order">
                                    <form class="hidden-sm hidden-xs action-buttons"
                                        action="student/withdrawApplication.html" method="post">
                                        <tr>
                                            <td>${order.starttime.substring(0,order.starttime.length()-3)}</td>
                                            <td class="hidden-480">${order.student.sname}</td>
                                            <td class="hidden-480">${order.snum}</td>
                                            <td class="hidden-480">${order.stelephone}</td>
                                            <td>${order.groupname}</td>
                                            <td>${order.theme}</td>
                                            <td>${order.faculty}</td>
                                            <td>${order.teacher}</td>
                                            <td>${order.teacher}</td>
                                            <td>
                                                <c:if test="${order.orderstatus == 0}">
                                                    <span class="label label-sm label-warning">申请中</span>
                                                </c:if>
                                                <c:if test="${order.orderstatus == 1}">
                                                    <span class="label label-sm label-success arrowed">同意</span>
                                                </c:if>
                                                <c:if test="${order.orderstatus == 2}">
                                                    <span
                                                        class="label label-sm label-inverse arrowed-in-right">拒绝</span>
                                                </c:if>
                                                <c:if test="${order.orderstatus == 3}">
                                                    <span class="label label-sm label-danger arrowed-in">撤销</span>
                                                </c:if>
                                                <c:if test="${order.orderstatus == 4}">
                                                    <span class="label label-sm label-info arrowed-in-right">已使用</span>
                                                </c:if>
                                            </td>

                                            <td>


                                                <input type="hidden" name="orderid" value="${order.orderid}" />
                                                <c:if test="${order.orderstatus == 1}">
                                                    <a type="button"
                                                        class="btn btn-minier btn-white btn-warning btn-bold"
                                                        name="application-word-export"
                                                        href="student/exportWord.html?orderid=${order.orderid}">
                                                        <i class="ace-icon fa fa-file-o bigger-100 green"></i>
                                                        导出表格
                                                    </a>
                                                </c:if>

                                                <c:if test="${order.orderstatus == 0}">
                                                    <a type="button"
                                                        class="btn btn-minier btn-white btn-warning btn-bold"
                                                        href="student/withdrawApplication.html?orderid=${order.orderid}">
                                                        <i class="ace-icon fa fa-trash-o bigger-100 orange"></i>
                                                        撤销申请
                                                    </a>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </form>
                                </c:forEach>
                            </tbody>

                        </table>

                    </div>
                </div><!-- /.page-content -->
            </div>
        </div><!-- /.main-content -->


        <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
            <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
        </a>
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
    <script src="${pageContext.request.contextPath}/assets/js/bootbox.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.easypiechart.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/jquery.gritter.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/spin.js"></script>

    <!-- ace scripts -->
    <script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>

    <!-- inline scripts related to this page -->

    <script type="text/javascript">
        jQuery(function ($) {
            /**
             $('#myTab a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
                      //console.log(e.target.getAttribute("href"));
                    })
    
             $('#accordion').on('shown.bs.collapse', function (e) {
                        //console.log($(e.target).is('#collapseTwo'))
                    });
             */

            $('#myTab a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
                //if($(e.target).attr('href') == "#home") doSomethingNow();
            })


            /**
             //go to next tab, without user clicking
             $('#myTab > .active').next().find('> a').trigger('click');
             */


            $('#accordion-style').on('click', function (ev) {
                var target = $('input', ev.target);
                var which = parseInt(target.val());
                if (which == 2) $('#accordion').addClass('accordion-style2');
                else $('#accordion').removeClass('accordion-style2');
            });

            //$('[href="#collapseTwo"]').trigger('click');


            $('.easy-pie-chart.percentage').each(function () {
                $(this).easyPieChart({
                    barColor: $(this).data('color'),
                    trackColor: '#EEEEEE',
                    scaleColor: false,
                    lineCap: 'butt',
                    lineWidth: 8,
                    animate: ace.vars['old_ie'] ? false : 1000,
                    size: 75
                }).css('color', $(this).data('color'));
            });

            $('[data-rel=tooltip]').tooltip();
            $('[data-rel=popover]').popover({ html: true });


            $('#gritter-regular').on(ace.click_event, function () {
                $.gritter.add({
                    title: 'This is a regular notice!',
                    text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="blue">magnis dis parturient</a> montes, nascetur ridiculus mus.',
                    image: '${pageContext.request.contextPath}/assets/images/avatars/avatar1.png', //in Ace demo ./dist will be replaced by correct ${pageContext.request.contextPath}/assets path
                    sticky: false,
                    time: '',
                    class_name: (!$('#gritter-light').get(0).checked ? 'gritter-light' : '')
                });

                return false;
            });

            $('#gritter-sticky').on(ace.click_event, function () {
                var unique_id = $.gritter.add({
                    title: 'This is a sticky notice!',
                    text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="red">magnis dis parturient</a> montes, nascetur ridiculus mus.',
                    image: '${pageContext.request.contextPath}/assets/images/avatars/avatar.png',
                    sticky: true,
                    time: '',
                    class_name: 'gritter-info' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
                });

                return false;
            });


            $('#gritter-without-image').on(ace.click_event, function () {
                $.gritter.add({
                    // (string | mandatory) the heading of the notification
                    title: 'This is a notice without an image!',
                    // (string | mandatory) the text inside the notification
                    text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="orange">magnis dis parturient</a> montes, nascetur ridiculus mus.',
                    class_name: 'gritter-success' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
                });

                return false;
            });


            $('#gritter-max3').on(ace.click_event, function () {
                $.gritter.add({
                    title: 'This is a notice with a max of 3 on screen at one time!',
                    text: 'This will fade out after a certain amount of time. Vivamus eget tincidunt velit. Cum sociis natoque penatibus et <a href="#" class="green">magnis dis parturient</a> montes, nascetur ridiculus mus.',
                    image: '${pageContext.request.contextPath}/assets/images/avatars/avatar3.png', //in Ace demo ./dist will be replaced by correct ${pageContext.request.contextPath}/assets path
                    sticky: false,
                    before_open: function () {
                        if ($('.gritter-item-wrapper').length >= 3) {
                            return false;
                        }
                    },
                    class_name: 'gritter-warning' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
                });

                return false;
            });


            $('#gritter-center').on(ace.click_event, function () {
                $.gritter.add({
                    title: 'This is a centered notification',
                    text: 'Just add a "gritter-center" class_name to your $.gritter.add or globally to $.gritter.options.class_name',
                    class_name: 'gritter-info gritter-center' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
                });

                return false;
            });

            $('#gritter-error').on(ace.click_event, function () {
                $.gritter.add({
                    title: 'This is a warning notification',
                    text: 'Just add a "gritter-light" class_name to your $.gritter.add or globally to $.gritter.options.class_name',
                    class_name: 'gritter-error' + (!$('#gritter-light').get(0).checked ? ' gritter-light' : '')
                });

                return false;
            });


            $("#gritter-remove").on(ace.click_event, function () {
                $.gritter.removeAll();
                return false;
            });


            ///////


            $("#bootbox-regular").on(ace.click_event, function () {
                bootbox.prompt("What is your name?", function (result) {
                    if (result === null) {

                    } else {

                    }
                });
            });

            $("#bootbox-confirm").on(ace.click_event, function () {
                bootbox.confirm("Are you sure?", function (result) {
                    if (result) {
                        //
                    }
                });
            });

            /**
             $("#bootbox-confirm").on(ace.click_event, function() {
                        bootbox.confirm({
                            message: "Are you sure?",
                            buttons: {
                              confirm: {
                                 label: "OK",
                                 className: "btn-primary btn-sm",
                              },
                              cancel: {
                                 label: "Cancel",
                                 className: "btn-sm",
                              }
                            },
                            callback: function(result) {
                                if(result) alert(1)
                            }
                          }
                        );
                    });
             **/


            $("#bootbox-options").on(ace.click_event, function () {
                bootbox.dialog({
                    message: "<span class='bigger-110'>I am a custom dialog with smaller buttons</span>",
                    buttons:
                    {
                        "success":
                        {
                            "label": "<i class='ace-icon fa fa-check'></i> Success!",
                            "className": "btn-sm btn-success",
                            "callback": function () {
                                //Example.show("great success");
                            }
                        },
                        "danger":
                        {
                            "label": "Danger!",
                            "className": "btn-sm btn-danger",
                            "callback": function () {
                                //Example.show("uh oh, look out!");
                            }
                        },
                        "click":
                        {
                            "label": "Click ME!",
                            "className": "btn-sm btn-primary",
                            "callback": function () {
                                //Example.show("Primary button");
                            }
                        },
                        "button":
                        {
                            "label": "Just a button...",
                            "className": "btn-sm"
                        }
                    }
                });
            });


            $('#spinner-opts small').css({ display: 'inline-block', width: '60px' })

            var slide_styles = ['', 'green', 'red', 'purple', 'orange', 'dark'];
            var ii = 0;
            $("#spinner-opts input[type=text]").each(function () {
                var $this = $(this);
                $this.hide().after('<span />');
                $this.next().addClass('ui-slider-small').addClass("inline ui-slider-" + slide_styles[ii++ % slide_styles.length]).css('width', '125px').slider({
                    value: parseInt($this.val()),
                    range: "min",
                    animate: true,
                    min: parseInt($this.attr('data-min')),
                    max: parseInt($this.attr('data-max')),
                    step: parseFloat($this.attr('data-step')) || 1,
                    slide: function (event, ui) {
                        $this.val(ui.value);
                        spinner_update();
                    }
                });
            });


            //CSS3 spinner
            $.fn.spin = function (opts) {
                this.each(function () {
                    var $this = $(this),
                        data = $this.data();

                    if (data.spinner) {
                        data.spinner.stop();
                        delete data.spinner;
                    }
                    if (opts !== false) {
                        data.spinner = new Spinner($.extend({ color: $this.css('color') }, opts)).spin(this);
                    }
                });
                return this;
            };

            function spinner_update() {
                var opts = {};
                $('#spinner-opts input[type=text]').each(function () {
                    opts[this.name] = parseFloat(this.value);
                });
                opts['left'] = 'auto';
                $('#spinner-preview').spin(opts);
            }


            $('#id-pills-stacked').removeAttr('checked').on('click', function () {
                $('.nav-pills').toggleClass('nav-stacked');
            });


            ///////////
            $(document).one('ajaxloadstart.page', function (e) {
                $.gritter.removeAll();
                $('.modal').modal('hide');
            });

        });
    </script>
</body>

</html>