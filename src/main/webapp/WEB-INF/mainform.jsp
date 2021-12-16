<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%--<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>--%>

<html>
<head>

    <%--<link rel="shortcut icon" href="https://accordbank.com.ua/images/icons/favicon.ico">--%>
    <link rel="shortcut icon" href="/accord.ico">
    <title>Нові відділення</title>

    <meta charset="utf-8" />

    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<%--    <link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" type="text/css" rel="stylesheet" />
    <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js" defer></script>--%>
    <link href="//datatables.net/download/build/nightly/jquery.dataTables.css" rel="stylesheet" type="text/css" />
    <script src="//datatables.net/download/build/nightly/jquery.dataTables.js"></script>
    <script src="//cdn.rawgit.com/ashl1/datatables-rowsgroup/v1.0.0/dataTables.rowsGroup.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/select/1.3.0/css/select.dataTables.css">
    <script src="https://cdn.datatables.net/select/1.3.0/js/dataTables.select.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/moment.js/2.7.0/moment.min.js" type="text/javascript"></script>

<%--    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/fixedheader/3.1.2/css/fixedHeader.dataTables.min.css">
    <script src="https://cdn.datatables.net/fixedheader/3.1.2/js/dataTables.fixedHeader.min.js" type="text/javascript"></script>--%>


    <script type="text/javascript">
        $(document).ready(function() {
            $('#divisionslist').DataTable({
                pageLength : 200,
                ajax : {
                    url : '${pageContext.request.contextPath}/findalldivisions',
                    dataSrc : ''
                },

                "orderFixed": [ 1, 'desc' ],
                'rowsGroup': [0,1,2,3,4],

                'createdRow': function(row, data, dataIndex){
                    // Use empty value in the "Office" column
                    // as an indication that grouping with COLSPAN is needed

                    if(data["datescreated"] === "К-ть днів до дедлайну" || data["datescreated"] === "Акцептування виконання заходу"){
                        // Add COLSPAN attribute
                        $('td:eq(5)', row).attr('colspan', 3);
                        $('td:eq(5)', row).css('text-align', 'center');
                        $('td:eq(5)', row).css('font-weight', '900');
                        // Hide required number of columns
                        // next to the cell with COLSPAN attribute
                        $('td:eq(6)', row).css('display', 'none');
                        $('td:eq(7)', row).css('display', 'none');
                        //this.api().cell($('td:eq(4)', row)).data('К-ть днів до дедлайну');
                              //return "К-ть днів до дедлайну";
                    }

                },

                columnDefs: [
                    { orderable: false, targets: '_all' }
                ],
/*                'columnDefs': [
                    {
                        'targets': 4,
                        'checkboxes': {
                            'selectRow': true
                        }
                    }
                ],*/

                scrollx: true,
                fixedHeader: {
                    header: true,
                },
                "oLanguage": {
                    "sSearch": "Пошук",
                    "sLengthMenu": "Показувати _MENU_ записів"
                },
                "dom": '<"pull-left"f><"pull-right"l>tip',
                info: false,
                paging: false,
                select: false,
                searching: false,
                /*"buttons" : [{
                    extend : 'collection',
                    text : 'Selection',
                    buttons : ['selectAll', 'selectNone']
                }, {
                    extend : 'collection',
                    text : 'Export',
                    buttons : ['excel', 'csv', 'pdf']
                }
                ],*/
                columns : [{
                    title : 'Змінити',
                    data : 'id',
                    "render": function(data, type, row, meta){
                        if(type === 'display'){
                            data = '<a href="/mainform/updatedivision/' + data + '">Змінити</a>';
                            /*data = '<a href="#" onClick="MyWindow=window.open(\'/mainform/updateclient/' + data + '\',\'MyWindow\', \'toolbar=no, location=no, directories=no, status=no, menubar=no titlebar=no resizable=yes, scrollbars=yes width=2000,height=2000\', \'popup\'); return false;">Змінити</a>'*/
                        }
                        return data;
                    },
                    className: "dt-body-center",
                    width: '1%'
                }, {
                    title : 'id',
                    data : 'id',
                    className: "dt-body-center",
                    width: '1%'/*,
                    "render": function(data, type, row, meta){
                        if(type === 'display'){
                            data = '<a href="/mainform/updateclient/' + data + '">' + data + '</a>';
                        }
                        return data;
                    }*/
                }, {
                    title : 'Номер відділення',
                    data : 'num',
                    className: "dt-body-center",
                    width: '1%'
                }, {
                    title : 'Повна адреса місцезнаходження',
                    data : 'address',
                    width: '20%'
                }, {
                    title : 'Примітки',
                    data : 'comments',
                    width: '30%'
                },
                    {
                    title: 'Дата створення заявки',
                    data: 'datescreated',
                    "render": function ( data, type, row, meta ) {
                        if (data !== 'К-ть днів до дедлайну' && data !== 'Акцептування виконання заходу'){
                            //return new Date(data.replace(" ","T")).toLocaleDateString("be-BY");
                            return  moment(new Date(data.replace(" ","T"))).format('DD.MM.YYYY');
                        }
                        return data;
                    },
                    className: "dt-body-center",
                    width: '1%'
                }, {
                    title: 'Планова дата відкриття ТТ',
                    data: 'datesplaned',
                    "render": function ( data, type, row, meta ) {
                        //return  moment(new Date(data).toLocaleDateString("be-BY")).format('DD.MM.YYYY');
                        //console.log(moment(new Date(data).toLocaleDateString("be-BY")).format('DD.MM.YYYY'));
                        //return  new Date(data).toLocaleDateString("be-BY");
                        return  moment(new Date(data.replace(" ","T"))).format('DD.MM.YYYY');
                    },
                    className: "dt-body-center",
                    width: '1%'
                }, {
                    title: 'К-ть днів до відкриття ТТ',
                    data: 'daystoopen',
                    "render": function ( data, type, row, meta ) {
                        //var date1 = new Date(row.datesplaned).toLocaleDateString("en-US");
                        //var date2 = new Date().toLocaleDateString("en-US");
                        //return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);

                        var date1 = moment(new Date(row.datesplaned).toLocaleDateString("en-US")).format('YYYY-MM-DDTHH:mm:ss');
                        var date2 = moment(new Date().toLocaleDateString("en-US")).format('YYYY-MM-DDTHH:mm:ss');
                        return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                    },
                    className: "dt-body-center",
                    width: '1%'
                },
                    {
                    title: 'Підписання договору оренди',
                    data: 'datesorendaRev',
                    "render": function ( data, type, row, meta ) {
                        if (!data.toString().startsWith("d") && data !== '0' && data !== '1'){
                            return new Date(data).toLocaleDateString("be-BY");
                            //return  moment(new Date(data.replace(" ","T"))).format('DD.MM.YYYY');
                        }
                        if (data === '0' || data === '1'){
                            var is_checked = data === '1' ? "checked" : "";
                            return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                        }
                        if(data.toString().substr(1,1) === '0'){
                            var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                            var date2 = new Date().toLocaleDateString("en-US");
                            return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                        }

                        return '<img src="/accord.ico">';
                        //return '<img id="sm1" class="smile" src="/1.jpeg" style="display: none">';
                    },
                        className: "dt-body-center",
                        width: '1%'
                }, {
                    title: 'Замовлення сейфів',
                    data: 'datessafesRev',
                    "render": function ( data, type, row, meta ) {
                        if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                            return new Date(data).toLocaleDateString("be-BY");
                        }
                        if (data === '0' || data === '1'){
                            var is_checked = data === '1' ? "checked" : "";
                            return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                        }
                        if(data.toString().substr(1,1) === '0'){
                            var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                            var date2 = new Date().toLocaleDateString("en-US");
                            return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                        }

                        return '<img src="/accord.ico">';
                    },
                        className: "dt-body-center",
                        width: '1%'
                }, {
                        title: 'Система відеонагляду',
                        data: 'datesvideoLoz',
                        "render": function ( data, type, row, meta ) {

                            if (!data.toString().startsWith("d") && data !== '0' && data !== '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';

                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Охоронна сигналізація',
                        data: 'datessignalLoz',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data !== '0' && data !== '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                            //return '<img id="sm1" class="smile" src="/1.jpeg" style="display: none">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Пожежна сигналізація',
                        data: 'datesfiresignalLoz',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Розробка схеми розміщення роб. місць',
                        data: 'datesworkplacePos',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Ремонт всередині',
                        data: 'datesremontPos',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Касові кабіни',
                        data: 'datescasacabinsPos',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Вивіска на відділенні',
                        data: 'datesbannerShyan',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Валюто-обмінне табло',
                        data: 'datesforextabloShyan',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Плакати та наклейки',
                        data: 'datesposterShyan',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Побудова каналу звязку',
                        data: 'datesconnectionSem',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Побудова СКС',
                        data: 'datessksSem',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Закупівля та встановлення комп. техніки',
                        data: 'datescomputersSem',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Доставка печаток та штампів',
                        data: 'datesstampsTsup',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Клінінг приміщення',
                        data: 'datescleaningTsup',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Закупівля касової техніки',
                        data: 'datescashregistersGritch',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }, {
                        title: 'Закупівля меблів',
                        data: 'datesmebliGritch',
                        "render": function ( data, type, row, meta ) {
                            if (!data.toString().startsWith("d") && data != '0' && data != '1'){
                                return new Date(data).toLocaleDateString("be-BY");
                            }
                            if (data === '0' || data === '1'){
                                var is_checked = data === '1' ? "checked" : "";
                                return '<input id="box" onclick="return false;" type="checkbox" **class="checkbox disabled"** ' + is_checked + ' />';
                            }
                            if(data.toString().substr(1,1) === '0'){
                                var date1 = new Date(data.toString().substr(2,data.toString().length)).toLocaleDateString("en-US");
                                var date2 = new Date().toLocaleDateString("en-US");
                                return parseInt((new Date(date1) - new Date(date2)) / (1000 * 60 * 60 * 24), 10);
                            }

                            return '<img src="/accord.ico">';
                        },
                        className: "dt-body-center",
                        width: '1%'
                    }
                ],
                rowCallback: function(row, data, index) {
                    //$('thead').find('th').eq(10).css('border-left', 'solid black');
/*                    $('thead').find('th').eq(10).css('background-color', 'dimgrey');
                    $('thead').find('th').eq(11).css('background-color', 'dimgrey');
                    $('thead').find('th').eq(12).css('background-color', 'dimgrey');
                    $('thead').find('th').eq(13).css('background-color', 'dimgrey');
                    $('thead').find('th').eq(14).css('background-color', 'grey');
                    $('thead').find('th').eq(15).css('background-color', 'grey');
                    $('thead').find('th').eq(16).css('background-color', 'grey');*/

                    //$('#box', row).prop('disabled', true);
                    if ( parseInt($(row).find('td:eq(6)').text()) <= 0) {
                        $(row).find('td:eq(6)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(7)').text()) <= 0) {
                        $(row).find('td:eq(7)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(8)').text()) <= 0) {
                        $(row).find('td:eq(8)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(9)').text()) <= 0) {
                        $(row).find('td:eq(9)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(10)').text()) <= 0) {
                        $(row).find('td:eq(10)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(11)').text()) <= 0) {
                        $(row).find('td:eq(11)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(12)').text()) <= 0) {
                        $(row).find('td:eq(12)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(13)').text()) <= 0) {
                        $(row).find('td:eq(13)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(14)').text()) <= 0) {
                        $(row).find('td:eq(14)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(15)').text()) <= 0) {
                        $(row).find('td:eq(15)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(15)').text()) <= 0) {
                        $(row).find('td:eq(15)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(16)').text()) <= 0) {
                        $(row).find('td:eq(16)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(17)').text()) <= 0) {
                        $(row).find('td:eq(17)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(18)').text()) <= 0) {
                        $(row).find('td:eq(18)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(19)').text()) <= 0) {
                        $(row).find('td:eq(19)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(20)').text()) <= 0) {
                        $(row).find('td:eq(20)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(21)').text()) <= 0) {
                        $(row).find('td:eq(21)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(22)').text()) <= 0) {
                        $(row).find('td:eq(22)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(23)').text()) <= 0) {
                        $(row).find('td:eq(23)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(24)').text()) <= 0) {
                        $(row).find('td:eq(24)').addClass('color');
                    }
                    if ( parseInt($(row).find('td:eq(25)').text()) <= 0) {
                        $(row).find('td:eq(25)').addClass('color');
                    }
                }
            });
        });

    </script>

    <style type="text/css">

        .tabs { width: 100%; padding: 0px; margin: 0 auto; }
        .tabs>input { display: none; }
        .tabs>div {
            display: none;
            padding: 12px;
            border: 1px solid #C0C0C0;
            background: #FFFFFF;
        }
        .tabs>label {
            font-family: "Helvetica Neue", Helvetica, sans-serif;
            font-size: small;
            display: inline-block;
            padding: 7px;
            margin: 0 -5px -1px 0;
            text-align: center;
            color: #666666;
            border: 1px solid #C0C0C0;
            background: #E0E0E0;
            cursor: pointer;
        }
        .tabs>input:checked + label {
            color: #000000;
            border: 1px solid #C0C0C0;
            border-bottom: 1px solid #FFFFFF;
            background: #FFFFFF;
        }
        #tab_1:checked ~ #txt_1,
        #tab_2:checked ~ #txt_2,
        #tab_3:checked ~ #txt_3,
        #tab_4:checked ~ #txt_4 { display: block; }

        .blue-button{
            background: #25A6E1;
            padding:3px 5px;
            color:#fff;
            font-family:'Helvetica Neue',sans-serif;
            font-size:12px;
            border-radius:2px;
            -moz-border-radius:2px;
            -webkit-border-radius:4px;
            border:1px solid #1A87B9
        }

        table {
            font-family: "Helvetica Neue", Helvetica, sans-serif;
            font-size: xx-small;
            /*width: 100%; padding: 0px; margin: 0 auto;*/

        }
        th {
            background:  crimson;
            color: white;
            position: -webkit-sticky;
            position: sticky;
            top: 0;
            z-index: 2;
            /*height: 110px;*/
        }
        td,th{
            border: 1px solid gray;
            text-align: left;
            padding: 5px 10px;
        }

        .text {
            text-align: center;
        }

        h1,h2,h3{
            color: red;
        }

        .center-justified {
            text-align: justify;
            margin: 0 auto;
            width: 60em;
            font-size: small;
        }

        body {
            /* 	font-family: 'Ubuntu', sans-serif; */
            /*font-weight: bold;*/
        }
        .select2-container {
            min-width: 800px;
        }

        .select2-results__option {
            padding-right: 20px;
            vertical-align: middle;
        }
        .select2-results__option:before {
            content: "";
            display: inline-block;
            position: relative;
            height: 20px;
            width: 20px;
            border: 2px solid #e9e9e9;
            border-radius: 4px;
            background-color: #fff;
            margin-right: 20px;
            vertical-align: middle;
        }
        .select2-results__option[aria-selected=true]:before {
            font-family:fontAwesome;
            content: "\f00c";
            color: #fff;
            background-color: red;
            border: 0;
            display: inline-block;
            padding-left: 3px;
        }


        .select2-container--default .select2-results__option[aria-selected=true] {
            background-color: #fff;
        }
        .select2-container--default .select2-results__option--highlighted[aria-selected] {
            background-color: #eaeaeb;
            color: #272727;
        }
        .select2-container--default .select2-selection--multiple {
            margin-bottom: 10px;
        }
        .select2-container--default.select2-container--open.select2-container--below .select2-selection--multiple {
            border-radius: 4px;
        }

        .select2-container--default.select2-container--focus .select2-selection--multiple {
            border-color: red;
            border-width: 2px;
        }

        .select2-container--open .select2-dropdown--below {

            border-radius: 6px;
            box-shadow: 0 0 10px rgba(0,0,0,0.5);

        }
        .select2-selection .select2-selection--multiple:after {
            content: 'hhghgh';
        }

        /* select with icons badges single*/
        .select-icon .select2-selection__placeholder .badge {
            display: none;
        }

        .select-icon .placeholder {
            /* 	display: none; */
        }
        .select-icon .select2-results__option:before,
        .select-icon .select2-results__option[aria-selected=true]:before {
            display: none !important;
            /* content: "" !important; */
        }
        .select-icon  .select2-search--dropdown {
            display: none;
        }

        .ok{
            background:  green;
        }

        .right{
            background:  black;
        }

        .minus{
            background:  red;
        }

        .plus{
            background:  green;
        }


        .table-wrapper {
            position:relative;
        }
        .table-scroll {
            height:570px;
            overflow:auto;
            margin-top:5px;
        }
        .table-wrapper table {
            width:100%;

        }
        .table-wrapper table * {
            //background:yellow;
            //color:black;
        }
        .table-wrapper table thead th .text {
            position:absolute;
            top:-20px;
            z-index:2;
            height:20px;
            width:35%;
            border:1px solid red;
        }

        .front-sign-in-right {
            padding-top: 9px;
            padding-right: 9px;
            position: absolute;
            top: 0;
            right:0;
            width: inherit;
            -webkit-transition: -webkit-transform 0.6s;
            -moz-transition: -moz-transform 0.6s;
            -o-transition: -o-transform 0.6s;
            transition: transform 0.6s;
            display : inline-block;
            text-align: right;
            font-family: "Helvetica Neue", Helvetica, sans-serif;
            font-size: small;
        }
        .front-sign-in-left {
            padding-top: 9px;
            position: absolute;
            top: 0;
            /*right:0;*/
            width: inherit;
            -webkit-transition: -webkit-transform 0.6s;
            -moz-transition: -moz-transform 0.6s;
            -o-transition: -o-transform 0.6s;
            transition: transform 0.6s;
            display : inline-block;
            font-family: "Helvetica Neue", Helvetica, sans-serif;
            font-size: small;
        }
        .color{
            background-color: yellow;
            color: red;
            font-weight: 900;
        }
        .pull-left{float:left!important;}
        .pull-right{float:right!important;}
    </style>
</head>
<body>

<div class="text">
    <img class="text" src="data:image/svg+xml;base64,PHN2ZyBpZD0ibC11LWciIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB3aWR0aD0iMTg3LjdweCIgaGVpZ2h0PSI0NC44cHgiIHZpZXdCb3g9IjAgMCAxODcuNyA0NC44IiBzdHlsZT0iZW5hYmxlLWJhY2tncm91bmQ6bmV3IDAgMCAxODcuNyA0NC44OyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8c3R5bGUgdHlwZT0idGV4dC9jc3MiPg0KCS5zdDB7ZmlsbC1ydWxlOmV2ZW5vZGQ7Y2xpcC1ydWxlOmV2ZW5vZGQ7ZmlsbDojQ0MwMDAwO30NCgkuc3Qxe2ZpbGwtcnVsZTpldmVub2RkO2NsaXAtcnVsZTpldmVub2RkO2ZpbGw6Izk5OTk5OTt9DQo8L3N0eWxlPg0KPHBhdGggY2xhc3M9InN0MCIgZD0iTTQzLjYsMjcuNUwyMi4xLDlMMC42LDI3LjVDMC4yLDI1LjgsMCwyNC4yLDAsMjIuNEMwLDEwLDkuOSwwLDIyLjEsMGMxMi4yLDAsMjIuMSwxMCwyMi4xLDIyLjQgQzQ0LjIsMjQuMiw0NCwyNS44LDQzLjYsMjcuNSBNMTAxLDM1LjFjMy41LDAsNS4yLTAuMiw2LjQtMC41YzIuNC0wLjcsNC0yLjMsNC44LTQuOGMwLjMtMC44LDAuNC0xLjUsMC40LTIuMiBjMC0yLjMtMC45LTQuNC0yLjYtNS45Yy0xLjYtMS40LTMuNi0yLTYtMmgtNC4xYy0wLjUsMC4xLTEsMC4zLTEuMiwwLjdjLTAuMiwwLjQtMC40LDAuOC0wLjUsMS4zdjE5LjZoMi44VjM1LjEgTTEwOC4yLDIyLjggYzAuOCwxLjMsMS4zLDMuMSwxLjMsNC45YzAsMS43LTAuNCwzLjEtMS4zLDQuNGMtMSwxLjQtMi4zLDIuMS0zLjksMi4xbC0zLjMsMFYyMS4xYzAtMC4zLDAuMi0wLjUsMC41LTAuNWwyLjcsMCBDMTA1LjksMjAuNSwxMDcuMywyMS4zLDEwOC4yLDIyLjh6IE04OC4yLDM1LjVjMi4zLDAsNC4yLTAuNyw1LjctMi4yYzEuNS0xLjUsMi4zLTMuNCwyLjMtNS44YzAtMi4zLTAuOC00LjItMi4zLTUuNiBjLTEuNS0xLjUtMy40LTIuMi01LjYtMi4yYy0yLjMsMC00LjIsMC43LTUuNiwyLjJjLTEuNSwxLjUtMi4yLDMuNC0yLjIsNS43YzAsMi4zLDAuNyw0LjIsMi4zLDUuN0M4NC4xLDM0LjgsODYsMzUuNSw4OC4yLDM1LjUgTTkyLjMsMzIuMWMtMSwxLjctMi4zLDIuNi00LDIuNmMtMS43LDAtMy0wLjgtNC0yLjNDODMuNSwzMSw4MywyOS40LDgzLDI3LjZjMC0xLjksMC40LTMuNSwxLjItNC45YzEtMS42LDIuMy0yLjQsNC0yLjQgYzEuNiwwLDIuOSwwLjcsMy45LDIuMmMwLjksMS4zLDEuMywyLjksMS4zLDQuNkM5My41LDI5LjEsOTMuMSwzMC43LDkyLjMsMzIuMXogTTcyLjgsMjQuNmw1LjUtNWgtMS4ybC02LjcsNi4xdi02LjFoLTIuOHYxNS41IGwyLjgtMC4xdi04LjJsMC41LTAuNWw2LjksOC44aDMuMUw3Mi44LDI0LjZ6IE01Ni4yLDEzbC05LjgsMjIuMWgxbDIuOC02LjNoMTBsMi44LDYuM2gzTDU2LjIsMTN6IE01MC43LDI3LjlsNC42LTEwLjNsNC41LDEwLjMgSDUwLjd6IE0xMTQuNSwzNC4ybDUtMTIuM2MwLjEtMC4yLDAuMy0wLjQsMC41LDBjMS42LDQsMy4zLDguMyw0LjksMTIuM0gxMTQuNXogTTExMi4xLDMzLjljMCwwLjUsMC4xLDAuOCwwLjEsMWMwLDAuNiwwLDEtMC4xLDEuMiBoMC4yYzAuMy0wLjMsMC42LTAuNSwxLjEtMC43YzAuNC0wLjEsMC45LTAuMiwxLjUtMC4zYzAuNiwwLDEuNCwwLDIuNSwwaDUuOGMxLjEsMCwyLjYsMCwzLjIsMGMwLjUsMCwxLDAuMSwxLjQsMC4zIGMwLjQsMC4xLDAuNywwLjQsMC45LDAuN2gwLjJjMC0wLjMtMC4xLTAuNy0wLjEtMS4yYzAtMC40LDAtMC43LDAuMS0xaC0xbC01LjUtMTMuMWMtMC4xLTAuMy0wLjMtMC42LTAuNS0wLjggCWMtMC4yLTAuMi0wLjQtMC40LTAuNi0wLjVjLTAuNS0wLjItMC45LTAuMi0xLjQsMGMtMC4yLDAuMS0wLjMsMC4yLTAuNSwwLjRjLTAuMiwwLjItMC4zLDAuNC0wLjUsMC42bC01LjgsMTMuM0gxMTIuMXoiLz4NCjxwYXRoIGNsYXNzPSJzdDEiIGQ9Ik01LjQsMzcuMWwxNi43LTIzbDE2LjcsMjNjLTQuMSw0LjctMTAsNy43LTE2LjcsNy43QzE1LjQsNDQuOCw5LjQsNDEuOCw1LjQsMzcuMSBNMTcyLDE5LjZoLTIuOHY2LjRoLTguMXYtNi40IGgtMi44djE1LjVoMi44di04LjJoOC4xdjguMmgyLjhWMTkuNnogTTE1Mi4xLDIxTDE1Mi4xLDIxYy0wLjItMC40LTAuNC0wLjctMC42LTAuOWMtMC4yLTAuMi0wLjUtMC40LTAuNy0wLjVjLTAuNC0wLjEtMC43LTAuMS0xLjEsMGMtMC4yLDAuMS0wLjQsMC4yLTAuNiwwLjRjLTAuNCwwLjQtMC42LDAuOS0wLjgsMS41bC00LjUsMTMuNmgxLjFsMS4yLTMuN2g2LjhsMS4yLDMuN2gyLjdMMTUyLjEsMjF6ICBNMTQ2LjQsMzAuNGMxLTMsMi02LDMtOWMwLTAuMSwwLjItMC4zLDAuMywwbDIuOCw5SDE0Ni40eiBNMTMxLDIxLjdjMC4xLTAuNSwwLjItMC45LDAuNS0xLjNjMC4zLTAuNSwwLjgtMC43LDEuNC0wLjhsNy44LDB2MC45IGMtMi4yLDAtNC40LDAtNi42LDBjLTAuMiwwLTAuMywwLjEtMC4zLDAuNGwwLDUuNmMwLjIsMCwwLjYsMCwxLjIsMGMwLjUsMCwwLjksMCwxLjIsMGMyLDAsMy41LDAuMiw0LjUsMC43IGMxLjUsMC43LDIuMiwxLjksMi4yLDMuN2MwLDEuMy0wLjUsMi40LTEuNiwzLjJjLTEsMC43LTIuMSwxLjEtMy41LDEuMUgxMzFWMjEuOEMxMzEsMjEuOCwxMzEsMjEuNywxMzEsMjEuN0wxMzEsMjEuNyBNMTM2LjksMjcuNSBjMSwwLDEuOSwwLjMsMi42LDAuOWMwLjcsMC42LDEuMSwxLjQsMS4xLDIuNGMwLDEtMC40LDEuOC0xLjEsMi40Yy0wLjcsMC42LTEuNiwwLjktMi42LDAuOWgtM3YtNi42SDEzNi45eiBNMTc5LjcsMjQuNmw1LjUtNSBsLTEuMiwwbC02LjcsNnYtNi4xaC0yLjh2MTUuNWwyLjgtMC4xdi04LjJsMC41LTAuNWw2LjksOC44aDMuMUwxNzkuNywyNC42eiIvPg0KPC9zdmc+">
</div>

<div class="front-sign-in-right">
    <img style="width: 15px; height: 15px;" class="text" src="data:image/webp;base64,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">
    <strong>${pageContext.request.userPrincipal.name}</strong>
    <br>
    <sec:authorize access="isAuthenticated()">
        <a href="/logout">вийти</a>
    </sec:authorize>
</div>

<div class="front-sign-in-left">
<%--    <sec:authorize access="hasRole('ROLE_ADMIN')">
        &lt;%&ndash;        <input type="button" style="background-color: crimson;color: white" onclick="location.href='/managersreports';" value="Управлінські звіти" />&ndash;%&gt;
        <input type="button" style="background-color: crimson;color: white" onClick="window.open('/managersreports','mywindow', 'menubar=no,location=no,resizable=no,scrollbars=no,status=no, width=3000, height=3000'); return false;" value="Управлінські звіти" />
        <input type="button" style="background-color: crimson;color: white" onclick="location.href='/risk';" value="Кредитні заявки" />
        <input type="button" style="background-color: crimson;color: white" onclick="location.href='/corp';" value="Кредитні заявки" />
    </sec:authorize>--%>
    <sec:authorize access="hasRole('ROLE_TOPS')">
<%--        <input type="button" style="background-color: crimson;color: white" onclick="location.href='/managersreports';" value="Управлінські звіти" />--%>
        <input type="button" style="background-color: crimson;color: white" onClick="window.open('/managersreports','mywindow', 'menubar=no,location=no,resizable=no,scrollbars=no,status=no, width=3000, height=3000'); return false;" value="Управлінські звіти" />
        <%--<input type="button" style="background-color: crimson;color: white" onclick="location.href='/risk';" value="Кредитні заявки" />--%>
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_RISK')">
        <%--        <input type="button" style="background-color: crimson;color: white" onclick="location.href='/managersreports';" value="Управлінські звіти" />--%>
        <%--<input type="button" style="background-color: crimson;color: white" onClick="window.open('/managersreports','mywindow', 'menubar=no,location=no,resizable=no,scrollbars=no,status=no, width=3000, height=3000'); return false;" value="Управлінські звіти" />--%>
        <input type="button" style="background-color: crimson;color: white" onclick="location.href='/risk';" value="Кредитні заявки" />
    </sec:authorize>
    <sec:authorize access="hasRole('ROLE_CORP')">
        <%--        <input type="button" style="background-color: crimson;color: white" onclick="location.href='/managersreports';" value="Управлінські звіти" />--%>
        <%--<input type="button" style="background-color: crimson;color: white" onClick="window.open('/managersreports','mywindow', 'menubar=no,location=no,resizable=no,scrollbars=no,status=no, width=3000, height=3000'); return false;" value="Управлінські звіти" />--%>
        <input type="button" style="background-color: crimson;color: white" onclick="location.href='/addnewdivision';" value="Створити нове відділення" />
    </sec:authorize>
<%--    <sec:authorize access="hasRole('ROLE_CORP') and hasRole('ROLE_USER')">
        <input type="button" style="background-color: crimson;color: white" onclick="location.href='/corp';" value="Кредитні заявки" />
    </sec:authorize>--%>
</div>


<%--<h5 class="text">Created by Nazar Mykhailechko</h5>--%>

<br>
<div class="tabs">
    <input type="radio" name="inset" value="" id="tab_1" checked>

    <label for="tab_1"><strong>Відкриття нових відділення</strong></label>

<%--    <input type="radio" name="inset" value="" id="tab_2">
    <label for="tab_2"><strong>Звіт по доходах та об'ємах операцій</strong></label>

    <input type="radio" name="inset" value="" id="tab_3">
    <label for="tab_3"><strong>Неактивні рахунки</strong></label>--%>



    <div id="txt_1">
        <div class="table-wrapper">
            <div class="table-scroll">
                <table id="divisionslist" class="compact hover" style="width: 100%">

                    <thead>
                    <tr>
                        <th rowspan="2" style="text-align: center">Змінити</th>
                        <th colspan="7" style="text-align: center; background: dimgrey; border: 2px black solid">Інформаці про відділення</th>
                        <th colspan="2" style="text-align: center; background-color: dimgrey; border: 2px black solid">Тип робіт і планова дата виконання, <span style="color: red">Ревуцький</span></th>
                        <th colspan="3" style="text-align: center; background-color: dimgrey; border: 2px black solid">Тип робіт і планова дата виконання, <span style="color: red">Лозинський</span></th>
                        <th colspan="3" style="text-align: center; background-color: dimgrey; border: 2px black solid">Тип робіт і планова дата виконання, <span style="color: red">Постол</span></th>
                        <th colspan="3" style="text-align: center; background-color: dimgrey; border: 2px black solid">Тип робіт і планова дата виконання, <span style="color: red">Шиян</span></th>
                        <th colspan="3" style="text-align: center; background-color: dimgrey; border: 2px black solid">Тип робіт і планова дата виконання, <span style="color: red">Семенцул</span></th>
                        <th colspan="2" style="text-align: center; background-color: dimgrey; border: 2px black solid">Тип робіт і планова дата виконання, <span style="color: red">Цюпко</span></th>
                        <th colspan="2" style="text-align: center; background-color: dimgrey; border: 2px black solid">Тип робіт і планова дата виконання, <span style="color: red">Грітчина</span></th>
                    </tr>
                    <tr>
                        <th>Змінити</th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                        <th></th>
                    </tr>
                    </thead>

                </table>
            </div>
        </div>
    </div>
<%--    <div id="txt_2">
        <div class="table-wrapper">
            <div class="table-scroll">
                <table id="commisdatalist" class="compact hover" style="width: 100%"></table>
            </div>
        </div>
    </div>
    <div id="txt_3">
        <div class="table-wrapper">
            <div class="table-scroll">
                <table id="clientsinactivelist" class="compact hover" style="width: 100%"></table>
            </div>
        </div>
&lt;%&ndash;        <p>Размеры содержимого вкладок</p>
        <p>могут отличаться по высоте!</p>&ndash;%&gt;
    </div>--%>

</div>
</body>

</html>