// Set new default font family and font color to mimic Bootstrap's default styling
Chart.defaults.global.defaultFontFamily = '-apple-system,system-ui,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif';
Chart.defaults.global.defaultFontColor = '#292b2c';
// Area Chart Example
var ctx = document.getElementById("myAreaChart");
var myLineChart = new Chart(ctx, {
	type : 'line',
	data : {
		labels : [ "Dec 1", "Dec 2", "Dec 3", "Dec 4", "Dec 5", "Dec 6",
				"Dec 7", "Dec 8", "Dec 9", "Dec 10", "Dec 11", "Dec 12",
				"Dec 13" ,"Dec 14" ,"Dec 15" ,"Dec 16" ,"Dec 17"],
		datasets : [ {
			label : "Sessions",
			lineTension : 0.3,
			backgroundColor : "rgba(2,117,216,0.2)",
			borderColor : "rgba(2,117,216,1)",
			pointRadius : 5,
			pointBackgroundColor : "rgba(2,117,216,1)",
			pointBorderColor : "rgba(255,255,255,0.8)",
			pointHoverRadius : 5,
			pointHoverBackgroundColor : "rgba(2,117,216,1)",
			pointHitRadius : 50,
			pointBorderWidth : 2,
			data : [  $("#1").html(), $("#2").html(),
					$("#3").html(), $("#4").html(), $("#5").html(),
					$("#6").html(), $("#7").html(), $("#8").html(),
					$("#9").html(), $("#10").html(), $("#11").html(),
					$("#12").html(), $("#13").html(), $("#14").html(),
					$("#15").html(),$("#16").html(),$("#17").html()],
		} ],
	},
	options : {
		scales : {
			xAxes : [ {
				time : {
					unit : 'date'
				},
				gridLines : {
					display : false
				},
				ticks : {
					maxTicksLimit : 7
				}
			} ],
			yAxes : [ {
				ticks : {
					min : 0,
					max : 10,
					maxTicksLimit : 5
				},
				gridLines : {
					color : "rgba(0, 0, 0, .125)",
				}
			} ],
		},
		legend : {
			display : false
		}
	}
});
