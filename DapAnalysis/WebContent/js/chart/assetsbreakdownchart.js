//Account Breakdown
var charti;
var legend;

function displayAssetsBreakdownChart(containerId, chartDataiJson, combineRow) {
    // PIE CHART
    charti = new AmCharts.AmPieChart();
    charti.marginRight = 0;
    charti.marginLeft = 0;
    charti.marginBottom = 0;
    charti.marginTop = 0;
    charti.dataProvider = chartDataiJson;
    charti.titleField = "Category";
    charti.descriptionField = "description";
	charti.backgroundAlpha = 1;
	charti.pullOutRadius = "0";
	charti.backgroundColor = "#FFFFFF";
	//charti.pieBaseColor = "#77EB2F";
	//charti.pieBrightnessStep = -10;
    charti.colors = ["#7498BF",  "#76B900",   "#F1AB00",  "#E96B12", "#F02333", "#A34BC8",  "#1854C7", "#A20303", "#DDDDDD", "#B7DD7E",  "#8FCDEA",  "#FEFA54", "#D39907","#999999", "#333333", "#000000", "#57032A", "#CA9726", "#990000", "#4B0C25"];
	charti.valueField = "amount";
	charti.radius = "65%";
	if(combineRow){
		charti.groupPercent = 5;
	}
	charti.labelsEnabled = 0;
    charti.outlineThickness = 2;
    charti.startDuration = .3;
    charti.startEffect = "<>";
	charti.sequencedAnimation = "true";
    charti.depth3D = 15;
    charti.angle = 35;
    charti.balloonText="[[description]]: [[percents]]% ($[[value]])";
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
	legend.valueText = "$[[value]]";
	legend.valueWidth = 83;
	
    charti.addLegend(legend);
    // WRITE
    charti.write(containerId);
};