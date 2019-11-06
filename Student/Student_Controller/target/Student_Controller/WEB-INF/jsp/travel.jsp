<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta charset="utf-8"/>
    <title>信息查询 - 经费管理系统</title>

    <meta name="description" content="Common UI Features &amp; Elements"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0"/>

    <link rel="shortcut icon" href="${pageContext.request.contextPath}/assets/images/logo/favicon.ico"
          type="image/x-icon"/>

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/assets/font-awesome/4.5.0/css/font-awesome.min.css"/>

    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery-ui.custom.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/jquery.gritter.min.css"/>

    <!-- text fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts.googleapis.com.css"/>

    <!-- ace styles -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace.min.css" class="ace-main-stylesheet"
          id="main-ace-style"/>

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-part2.min.css"
          class="ace-main-stylesheet"/>
    <![endif]-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-skins.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ace-rtl.min.css"/>

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

        .dropdown-preview > .dropdown-menu {
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
                        <img class="nav-user-photo"
                             src="${pageContext.request.contextPath}/assets/images/avatars/用户1.png" alt="User's Photo"/>
                        <span class="user-info">
                                <small>Welcome,</small>
                                ${pername}
                            </span>

                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>

                    <ul
                            class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">

                        <li>
                            <a href="./exit">
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
                        <a href="#">新建报销</a>
                    </li>
                    <li class="active">差旅报销</li>
                </ul><!-- /.breadcrumb -->

            </div>

            <div class="page-content">

                <div class="page-header">
                    <h1>
                        差旅报销
                    </h1>
                </div><!-- /.page-header -->

                <div class="row">
                    <p style="height: 30px;font-size: x-large;color: red">${errormassage}</p>

                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <form action="./gettravelapply" class="form-horizontal" id="stuApplication" role="form"
                              method="post" onsubmit="return validAll()">
                            <div class="row">

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right"
                                    >报销类别</label>
                                    <div class="col-sm-9">
                                        <div class="clearfix">
                                            <select id="applytype" name="leibie" required onchange="SelectChange1()">
                                                <option value="">请选择</option>
                                                <option value="project">大创项目</option>
                                                <option value="studio">工作室</option>
                                                <option value="competition">竞赛</option>
                                                <option value="others">其他</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group" id="hide1" style="display: none">
                                    <label class="col-sm-3 control-label no-padding-right"
                                    >项目名称</label>
                                    <div class="col-sm-9">
                                        <div class="clearfix">
                                            <select id="project name" name="pid"  onchange="SelectChange1()">
                                                <option value="">请选择</option>
                                                <c:forEach items="${project}" var="p">
                                                    <option value="${p.proid}">${p.proid}-${p.proname}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="space-2"></div>
                                    </div>
                                </div>

                                <div class="form-group" id="hide2" style="display: none">
                                    <label class="col-sm-3 control-label no-padding-right"
                                    >工作室名称</label>
                                    <div class="col-sm-9">
                                        <div class="clearfix">
                                            <select id="studio name" name="sid"  onchange="SelectChange1()">
                                                <option value="">请选择</option>
                                                <c:forEach items="${studio}" var="s">
                                                    <option value="${s.sid}">${s.sid}-${s.sname}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="space-2"></div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right"
                                    >报销人</label>

                                    <div class="col-sm-9">
                                        <div class="clearfix">
                                            <input class="col-xs-1" type="text" name="people" id="person"
                                                   placeholder="" value="${pername}" required readonly
                                                   style="width: auto;" />
                                        </div>

                                        <div class="space-2"></div>

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right"
                                    >联系电话</label>

                                    <div class="col-sm-9">
                                        <div class="inline">
                                            <input type="text" name="tel" id="form-field-tags-1"
                                                   value="" placeholder="填自己在用的电话"
                                                   title="填自己在用的电话，以便于老师临时通知" style="width: auto;"
                                            />
                                        </div>
                                        <span id="errorStelephone"></span>
                                        <div class="space-2"></div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">出差日期</label>
                                    <div class="col-sm-9">
                                        <div class="clearfix">
                                            <input class="" type="date" name="startdate" id="startdate" placeholder="" value=""
                                                   step="0.01" required />
                                            <label class="control-label">至</label>
                                            <input class="" type="date" name="enddate" id="enddate" placeholder="" value=""
                                                   step="0.01" required />
                                        </div>
                                        <div class="space-2"></div>
                                    </div>
                                </div>
                                <!--</div>-->

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">出差事由</label>

                                    <div class="col-sm-9">
                                        <div class="clearfix">
                                            <input class="col-xs-1" type="text" name="mission" id="mission" placeholder=""
                                                   value="" required />
                                        </div>

                                        <div class="space-2"></div>

                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">出差地点</label>

                                    <div class="col-sm-9">
                                        <div class="inline">
                                            <input type="text" name="place" id="place" value="" placeholder="" title="" />
                                        </div>
                                        <div class="space-2"></div>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">住宿费</label>

                                    <div class="col-sm-9">
                                        <input class="col-xs-1" type="text" id="hmoney" placeholder="" name="hmoney"
                                               value="" />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">会议费</label>

                                    <div class="col-sm-9">
                                        <input class="col-xs-1" type="text" id="mmoney" placeholder="" name="mmoney"
                                               value="" />
                                    </div>
                                </div>

                                <div class="form-group" id="">
                                    <label class="col-sm-3 control-label no-padding-right">总额</label>

                                    <div class="col-sm-9">
                                        <input class="col-xs-1" type="text" id="tmoney" placeholder="" name="tmoney" required
                                               value="" />
                                    </div>
                                </div>

                                <!--右-->

                                <button class="btn btn-info" type="button" onclick="add()"
                                        style="float: right;">添加</button>
                                <table class="table table-bordered table-striped" id="table" border="1">
                                    <tr>
                                        <td>姓名</td>
                                        <td>出行方式</td>
                                        <td>票价</td>
                                        <td>删除</td>
                                    </tr>
                                </table>

                                <p style="height: 30px;font-size: x-large;color: red">提交前请先确认填写具体人员表格 ↑</p>

                                <div class="clearfix form-actions">
                                    <div class="col-md-offset-3 col-md-9">
                                        <button class="btn btn-info" type="submit">
                                            <i class="ace-icon fa fa-check bigger-110"></i>
                                            提交
                                        </button>
                                        &nbsp; &nbsp; &nbsp;
                                        <button type="reset" class="btn">
                                            <i class="ace-icon fa fa-undo bigger-110"></i>
                                            重置
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
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
            $('[data-rel=popover]').popover({html: true});


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


            $('#spinner-opts small').css({display: 'inline-block', width: '60px'})

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
                        data.spinner = new Spinner($.extend({color: $this.css('color')}, opts)).spin(this);
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

    <script type="text/javascript">
        // 编写一个函数，供添加按钮调用，动态在表格的最后一行添加子节点；
        // var num = document.getElementsByTagName('tr').length - 1;
        // var num1 = document.getElementById('table').length - 1;

        function add() {


            var tr = document.createElement("tr");
            // var str = '<td >' + num1 + '</td>';
            // str += '<td>' + lname + '</td>';
            // str += '<td>' + lwork + '</td>';
            // str += '<td>' + unitprice + '</td>';
            // str += '<td>' + money + '</td>';
            // str += '<td>' + quantity + '</td>';
            // str += '<td><button onclick="del(this)" >删除</button></td>';
            // tr.innerHTML = str;
            var tab = document.getElementById("table");
            tr.innerHTML =
                "                        <td><input name=\"pname\" required></td>\n" +
                " <select id=\"transport\" name=\"transport\" required>\n" +
                "                                                    <option value=\"\">请选择</option>\n" +
                "                                                    <option value=\"飞机\">飞机</option>\n" +
                "                                                    <option value=\"火车\">火车</option>\n" +
                "                                                    <option value=\"轮船\">轮船</option>\n" +
                "                                                    <option value=\"汽车\">汽车</option>\n" +
                "                                                </select>\n" +
                "                        <td><input name=\"money\" required></td>\n" +
                "                        <td>\n" +
                "                            <div class=\"col-xs-12\">\n" +
                "                                <a onclick=\"del(this)\"><span>删除</span></a>\n" +
                "                            </div>\n" +
                "                        </td>"
            tab.appendChild(tr);
        }

        // 创建删除函数
        function del(obj) {
            var tr = obj.parentNode.parentNode.parentNode;
            tr.parentNode.removeChild(tr);
        }
    </script>

    <script type="text/javascript">
        function SelectChange1() {
            var applytype = document.getElementById("applytype");
            var hide1 = document.getElementById("hide1");
            var hide2 = document.getElementById("hide2");
            var hide3 = document.getElementById("hide3");
            if (applytype.value=="project"){
                hide1.style=""
                hide2.style="display:none"
                hide3.style="display:none"
            }else if (applytype.value=="studio"){
                hide1.style="display:none"
                hide2.style=""
                hide3.style="display:none"
            }else if (applytype.value=="competition"){
                hide1.style="display:none"
                hide2.style="display:none"
                hide3.style=""
            }else {
                hide1.style="display:none"
                hide2.style="display:none"
                hide3.style="display:none"
            }
        }

    </script>

</body>

</html>