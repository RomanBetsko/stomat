$(function () {

    var mounthsData;

    $(document).ready(function () {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/admin/api/appointmentsGraph",
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                mounthsData = data;
                Morris.Bar({
                    element: 'morris-bar-chart',
                    data: [{
                        y: 'Січень',
                        a: mounthsData[0].a,
                        b: mounthsData[0].b
                    }, {
                        y: 'Лютий',
                        a: mounthsData[1].a,
                        b: mounthsData[1].b
                    }, {
                        y: 'Березень',
                        a: mounthsData[2].a,
                        b: mounthsData[2].b
                    }, {
                        y: 'Квітень',
                        a: mounthsData[3].a,
                        b: mounthsData[3].b
                    }, {
                        y: 'Травень',
                        a: mounthsData[4].a,
                        b: mounthsData[4].b
                    }, {
                        y: 'Червень',
                        a: mounthsData[5].a,
                        b: mounthsData[5].b
                    }, {
                        y: 'Липень',
                        a: mounthsData[6].a,
                        b: mounthsData[6].b
                    }, {
                        y: 'Серпень',
                        a: mounthsData[7].a,
                        b: mounthsData[7].b
                    }, {
                        y: 'Вересень',
                        a: mounthsData[8].a,
                        b: mounthsData[8].b
                    }, {
                        y: 'Жовтень',
                        a: mounthsData[9].a,
                        b: mounthsData[9].b
                    }, {
                        y: 'Листопад',
                        a: mounthsData[10].a,
                        b: mounthsData[10].b
                    }, {
                        y: 'Грудень',
                        a: mounthsData[11].a,
                        b: mounthsData[11].b
                    }],
                    xkey: 'y',
                    ykeys: ['a', 'b'],
                    labels: ['2019', '2020'],
                    barColors: ['#343957', '#5873FE'],
                    hideHover: 'auto',
                    gridLineColor: '#eef0f2',
                    resize: true
                });
            },
            error: function (e) {

            }
        });
    });
    "use strict";
    // Morris bar chart


    $(document).ready(function () {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/admin/api/earnGraph",
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                Morris.Line({

                    element: 'morris-line-chart',
                    resize: true,
                    data: data,
                    xkey: 'y',
                    ykeys: ['item1'],
                    labels: ['Item 1'],
                    gridLineColor: '#eef0f2',
                    lineColors: ['#007BFF'],
                    lineWidth: 1,
                    hideHover: 'auto'
                });
            },
            error: function (e) {

            }
        })
    });


    // LINE CHART

    // Morris donut chart

    $(document).ready(function () {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: "/admin/api/procedureGraph",
            dataType: 'json',
            cache: false,
            timeout: 600000,
            success: function (data) {
                Morris.Donut({
                    element: 'morris-donut-chart',
                    data: data,
                    resize: true,
                    // colors: ['#007BFF', '#28A745', '#DC3545']
                });
            }, error: function (e) {

            }
        })
    });




    // Extra chart
    Morris.Area({
        element: 'extra-area-chart',
        data: [{
            period: '2001',
            smartphone: 0,
            windows: 0,
            mac: 0
        }, {
            period: '2002',
            smartphone: 90,
            windows: 60,
            mac: 25
        }, {
            period: '2003',
            smartphone: 40,
            windows: 80,
            mac: 35
        }, {
            period: '2004',
            smartphone: 30,
            windows: 47,
            mac: 17
        }, {
            period: '2005',
            smartphone: 150,
            windows: 40,
            mac: 120
        }, {
            period: '2006',
            smartphone: 25,
            windows: 80,
            mac: 40
        }, {
            period: '2007',
            smartphone: 10,
            windows: 10,
            mac: 10
        }


        ],
        lineColors: ['#28A745', '#DC3545', '#007BFF'],
        xkey: 'period',
        ykeys: ['smartphone', 'windows', 'mac'],
        labels: ['Phone', 'Windows', 'Mac'],
        pointSize: 0,
        lineWidth: 0,
        resize: true,
        fillOpacity: 0.8,
        behaveLikeLine: true,
        gridLineColor: '#e0e0e0',
        hideHover: 'auto'

    });
    Morris.Area({
        element: 'morris-area-chart',
        data: [{
            period: '2001',
            smartphone: 0,
            windows: 0,
            mac: 0
        }, {
            period: '2002',
            smartphone: 90,
            windows: 60,
            mac: 25
        }, {
            period: '2003',
            smartphone: 40,
            windows: 80,
            mac: 35
        }, {
            period: '2004',
            smartphone: 30,
            windows: 47,
            mac: 17
        }, {
            period: '2005',
            smartphone: 150,
            windows: 40,
            mac: 120
        }, {
            period: '2006',
            smartphone: 25,
            windows: 80,
            mac: 40
        }, {
            period: '2007',
            smartphone: 10,
            windows: 10,
            mac: 10
        }


        ],
        xkey: 'period',
        ykeys: ['smartphone', 'windows', 'mac'],
        labels: ['Phone', 'Windows', 'Mac'],
        pointSize: 3,
        fillOpacity: 0,
        pointStrokeColors: ['#28A745', '#007BFF', '#DC3545'],
        behaveLikeLine: true,
        gridLineColor: '#e0e0e0',
        lineWidth: 3,
        hideHover: 'auto',
        lineColors: ['#28A745', '#007BFF', '#DC3545'],
        resize: true

    });

    Morris.Area({
        element: 'morris-area-chart2',
        data: [{
            period: '2010',
            SiteA: 0,
            SiteB: 0,

        }, {
            period: '2011',
            SiteA: 130,
            SiteB: 100,

        }, {
            period: '2012',
            SiteA: 80,
            SiteB: 60,

        }, {
            period: '2013',
            SiteA: 70,
            SiteB: 200,

        }, {
            period: '2014',
            SiteA: 180,
            SiteB: 150,

        }, {
            period: '2015',
            SiteA: 105,
            SiteB: 90,

        },
            {
                period: '2016',
                SiteA: 250,
                SiteB: 150,

            }],
        xkey: 'period',
        ykeys: ['SiteA', 'SiteB'],
        labels: ['Site A', 'Site B'],
        pointSize: 0,
        fillOpacity: 0.4,
        pointStrokeColors: ['#b4becb', '#007BFF'],
        behaveLikeLine: true,
        gridLineColor: '#e0e0e0',
        lineWidth: 0,
        smooth: false,
        hideHover: 'auto',
        lineColors: ['#b4becb', '#007BFF'],
        resize: true

    });


});
