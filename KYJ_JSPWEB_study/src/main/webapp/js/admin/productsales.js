let jsonlist;
$(function(){
	$.ajax({
		url:"getchart",
		data:{"type":1},
		success:function(jsonlist){
			console.log(jsonlist);
			
			////////////////////////////////////////// amChart 구역 //////////////////////////////////////////
			am5.ready(function() {
			
			// Create root element
			// https://www.amcharts.com/docs/v5/getting-started/#Root_element
			var root = am5.Root.new("chartdiv1");
			
			
			// Set themes
			// https://www.amcharts.com/docs/v5/concepts/themes/
			root.setThemes([
			  am5themes_Animated.new(root)
			]);
			
			
			// Create chart
			// https://www.amcharts.com/docs/v5/charts/xy-chart/
			var chart = root.container.children.push(am5xy.XYChart.new(root, {
			  panX: false,
			  panY: false,
			  wheelX: "panX",
			  wheelY: "zoomX"
			}));
			
			
			// Add cursor
			// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
			var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
			  behavior: "zoomX"
			}));
			cursor.lineY.set("visible", false);
			
			//var date = new Date();
			//date.setHours(0, 0, 0, 0);
			//var value = 100;
			
			function generateData(i) {
				// 1. i번째 객체에서 값 가져오기
			 let value = parseInt(jsonlist[i]["value"]);	// 문자열 -> 정수 형변환
				// 2. i번쨰 객체에서 날짜 가져오기
					// * 문자열 -> 날짜형식 : [ new Date("문자열");]
			  let date = new Date(jsonlist[i]["date"]);
			  date.setHours(0, 0, 0, 0);
			  am5.time.add(date,"day",1);
			  
			  return {
			    date: date.getTime(),
			    value: value
			  };
			}
			
			function generateDatas(count) {
			  var data = [];
			  for (var i = 0; i < count; ++i) {
			    data.push(generateData(i));	// 인덱스 카운트 해야 하기 때문에 인수로 전달
			  }
			  return data;
			}
			
			
			// Create axes
			// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
			var xAxis = chart.xAxes.push(am5xy.DateAxis.new(root, {
			  maxDeviation: 0,
			  baseInterval: {
			    timeUnit: "day",
			    count: 1
			  },
			  renderer: am5xy.AxisRendererX.new(root, {}),
			  tooltip: am5.Tooltip.new(root, {})
			}));
			
			var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
			  renderer: am5xy.AxisRendererY.new(root, {})
			}));
			
			
			// Add series
			// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
			var series = chart.series.push(am5xy.ColumnSeries.new(root, {
			  name: "Series",
			  xAxis: xAxis,
			  yAxis: yAxis,
			  valueYField: "value",
			  valueXField: "date",
			  tooltip: am5.Tooltip.new(root, {
			    labelText: "{valueY}"
			  })
			}));
			
			
			
			// Add scrollbar
			// https://www.amcharts.com/docs/v5/charts/xy-chart/scrollbars/
			chart.set("scrollbarX", am5.Scrollbar.new(root, {
			  orientation: "horizontal"
			}));
			
			var data = generateDatas(jsonlist.length);	// 차트에 들어가는 데이타
			series.data.setAll(data);
			
			
			// Make stuff animate on load
			// https://www.amcharts.com/docs/v5/concepts/animations/
			series.appear(1000);
			chart.appear(1000, 100);
			
			}); // end am5.ready(
			////////////////////////////////////////// amChart bar형 차트 구역 end//////////////////////////////////////////		
			
			categorychart();
			
		}
	});
});	// $(function(){ end

function categorychart(){
	$.ajax({
		url:"getchart",
		data:{"type":2},
		success:function(jsonlist2){
			console.log(jsonlist2);
////////////////////////////////////////// amChart pie차트 구역 시작 //////////////////////////////////////////
			
			am5.ready(function() {

			// Create root element
			// https://www.amcharts.com/docs/v5/getting-started/#Root_element
			var root = am5.Root.new("chartdiv2");
			
			// Set themes
			// https://www.amcharts.com/docs/v5/concepts/themes/
			root.setThemes([
			  am5themes_Animated.new(root)
			]);
			
			// Create chart
			// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/
			var chart = root.container.children.push(
			  am5percent.PieChart.new(root, {
			    endAngle: 270
			  })
			);
			
			// Create series
			// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Series
			var series = chart.series.push(
			  am5percent.PieSeries.new(root, {
			    valueField: "value",
			    categoryField: "category",
			    endAngle: 270
			  })
			);
			
			series.states.create("hidden", {
			  endAngle: -90
			});
			
			// Set data
			// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Setting_data
			series.data.setAll([{
			  category: "Lithuania",
			  value: 501.9
			}, {
			  category: "Czechia",
			  value: 301.9
			}, {
			  category: "Ireland",
			  value: 201.1
			}, {
			  category: "Germany",
			  value: 165.8
			}, {
			  category: "Australia",
			  value: 139.9
			}, {
			  category: "Austria",
			  value: 128.3
			}, {
			  category: "UK",
			  value: 99
			}]);
			
			series.appear(1000, 100);
			
			}); // end am5.ready()
		}
	});
};


