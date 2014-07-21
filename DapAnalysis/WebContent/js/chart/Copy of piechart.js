var chart;
function displayPieChart(containerId, jsonData, callBackFunction) {
	var chartData = jsonData;
	(function() {
		chart = new AmCharts.AmPieChart();
		chart.dataProvider = chartData;
		chart.titleField = "issueName";
		chart.backgroundAlpha = 1;
		chart.pullOutRadius = "10";
		chart.backgroundColor = "#FFFFFF";
		chart.colorField = "color";
		chart.valueField = "issueAmount";
		chart.radius = "30%";
		chart.outlineThickness = 2;
		chart.startDuration = .5;
		chart.startEffect = "<>";
		chart.sequencedAnimation = "true";
		chart.depth3D = 15;
		chart.angle = 10;
		chart.percentFormatter = {precision:0, decimalSeparator:'.', thousandsSeparator:','};

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
