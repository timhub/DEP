
function displayDAPPieChart(containerId, jsonData) {
	var chart;
	var chartData = jsonData;
		chart = new AmCharts.AmPieChart();
		chart.dataProvider = chartData;
		chart.titleField = "colName";
		chart.backgroundAlpha = 2;
		chart.pullOutRadius = "10";
		chart.backgroundColor = "#FFFFFF";
		//chart.colorField = ["#1d3246","#284661","#345a7d","#406e99","#6795c0","#83a8cb"];
		chart.colors=["#B71B1C","#d92021","#e33e3f","#e86061","#ed8283","#7f1314","#a11819","#c31d1f","#df292a","#e44b4c","#e96d6e","#cd1f20","#e03335","#B71B1C","#d92021","#e33e3f","#e86061","#ed8283","#7f1314","#a11819","#c31d1f","#df292a","#e44b4c","#e96d6e","#cd1f20","#e03335","#B71B1C","#d92021","#e33e3f","#e86061","#ed8283","#7f1314","#a11819","#c31d1f","#df292a","#e44b4c","#e96d6e","#cd1f20","#e03335","#B71B1C","#d92021","#e33e3f","#e86061","#ed8283","#7f1314","#a11819","#c31d1f","#df292a","#e44b4c","#e96d6e","#cd1f20","#e03335"];
		chart.valueField = "amount";
		chart.radius = "30%";
		chart.outlineThickness = 1;
		chart.startDuration = .4;
		chart.startEffect = ">";
		//chart.sequencedAnimation = "true";
		chart.depth3D = 10;
		chart.angle = 10;
		chart.percentFormatter = {precision:2, decimalSeparator:'.', thousandsSeparator:','};
		chart.groupPercent = 1;
		
		chart.outlineColor = "#FFFFFF";
        chart.outlineAlpha = 0.8;

		 // LEGEND

        var legend = new AmCharts.AmLegend();
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
        
		chart.write(containerId);
}

