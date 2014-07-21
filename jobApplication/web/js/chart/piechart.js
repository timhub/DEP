var chart;
function displayPieChart(containerId, jsonData,callBackFunction) {
	var chartData = jsonData;
	(function() {
		chart = new AmCharts.AmPieChart();
		chart.dataProvider = chartData;
		chart.titleField = "issueName";
		chart.backgroundAlpha = 2;
		chart.pullOutRadius = "10";
		chart.backgroundColor = "#FFFFFF";
		//chart.colorField = ["#1d3246","#284661","#345a7d","#406e99","#6795c0","#83a8cb"];
		chart.colors=["#1d3246","#284661","#345a7d","#406e99","#6795c0","#83a8cb","#223a50","#2e4e6b","#3a6286","#4676a2","#588ab7","#739dc3","#8fb0cf"];
		chart.valueField = "issueAmount";
		chart.radius = "30%";
		chart.outlineThickness = 1;
		chart.startDuration = .8;
//		chart.startEffect = "<>";
		chart.sequencedAnimation = "true";
		chart.depth3D = 10;
		chart.angle = 10;
		chart.percentFormatter = {precision:2, decimalSeparator:'.', thousandsSeparator:','};
		chart.groupPercent = 1;
		
		chart.outlineColor = "#FFFFFF";
        chart.outlineAlpha = 0.8;

		 // LEGEND

        legend = new AmCharts.AmLegend();
        legend.align = "center";
        legend.markerType = "square";
        legend.markerLabelGap = 5;
        legend.markerSize = 10;
        legend.marginTop = 0;
        legend.marginBottom = 0;
        legend.position = "right";
        legend.fontSize = 10;
        legend.valueText = "[[value]]";
        legend.valueWidth = 83;
        
        chart.addLegend(legend);
        
		chart.addListener("clickSlice", callBackFunction);
		chart.write(containerId);
	})();
}

