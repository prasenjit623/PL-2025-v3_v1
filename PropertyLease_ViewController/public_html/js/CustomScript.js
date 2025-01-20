function getValues(val){
if(document.getElementById("r4:2:pt1:it23::content") != null){
    var numVal1=parseInt(document.getElementById("r4:2:pt1:it23::content").value);
     if(isNaN(numVal1)==true){
        numVal1=0;
    }
    }else{
    var numBR=parseInt(document.getElementById("r4:0:pt1:it23::content").value);
    if(isNaN(numBR)==true){
        numBR=0;
    }
    }
if(document.getElementById("r4:2:pt1:it11::content") != null){
    var numVal2=parseInt(document.getElementById("r4:2:pt1:it11::content").value);
     if(isNaN(numVal2)==true){
        numVal2=0;
    }
    }else{
    var numPone=parseInt(document.getElementById("r4:0:pt1:it11::content").value);
     if(isNaN(numPone)==true){
        numPone=0;
    }
    }
if(document.getElementById("r4:2:pt1:it12::content") != null){
    var numVal3=parseInt(document.getElementById("r4:2:pt1:it12::content").value);
     if(isNaN(numVal3)==true){
        numVal3=0;
    }
    }else{
    var numPtwo=parseInt(document.getElementById("r4:0:pt1:it12::content").value);
    if(isNaN(numPtwo)==true){
        numPtwo=0;
    }
    }
if(document.getElementById("r4:2:pt1:it13::content") != null){
    var numVal4=parseInt(document.getElementById("r4:2:pt1:it13::content").value);
    if(isNaN(numVal4)==true){
        numVal4=0;
    }
    }else{
    var numPthree=parseInt(document.getElementById("r4:0:pt1:it13::content").value);
     if(isNaN(numPthree)==true){
        numPthree=0;
    }
    }
if(document.getElementById("r4:2:pt1:it14::content") != null){
    var numVal5=parseInt(document.getElementById("r4:2:pt1:it14::content").value);
     if(isNaN(numVal5)==true){
        numVal5=0;
    }
    }else{
    var numPfour=parseInt(document.getElementById("r4:0:pt1:it14::content").value);
    if(isNaN(numPfour)==true){
        numPfour=0;
    }
    }
if(document.getElementById("r4:2:pt1:it15::content") != null){
    var numVal6=parseInt(document.getElementById("r4:2:pt1:it15::content").value);
     if(isNaN(numVal6)==true){
        numVal6=0;
    }
    }else{
    var numPfive=parseInt(document.getElementById("r4:0:pt1:it15::content").value);
     if(isNaN(numPfive)==true){
        numPfive=0;
    }
    }
if(document.getElementById("r4:2:pt1:it22::content") != null){
    var numValCA=parseInt(document.getElementById("r4:2:pt1:it22::content").value);
    if(isNaN(numValCA)==true){
        numValCA=0;
    }
    }else{
    var CA=parseInt(document.getElementById("r4:0:pt1:it22::content").value);
    if(isNaN(CA)==true){
        CA=0;
    }
    }
    
    if(document.getElementById("r4:2:pt1:it16::content") != null){
        var totalValue=numVal1 + numVal2 + numVal3 + numVal4 + numVal5 + numVal6;
        document.getElementById("r4:2:pt1:it16::content").value = totalValue;
        document.getElementById("r4:2:pt1:it16::content").readOnly = true;
        }else{
        var rtotalValue = numBR + numPone + numPtwo + numPthree + numPfour + numPfive;
    document.getElementById("r4:0:pt1:it16::content").value = rtotalValue;
    document.getElementById("r4:0:pt1:it16::content").readOnly = true;
        }
    if(document.getElementById("r4:2:pt1:it17::content") != null){
        var purchaseValue= totalValue * numValCA;
        document.getElementById("r4:2:pt1:it17::content").value = purchaseValue;
        document.getElementById("r4:2:pt1:it17::content").readOnly = true;
        }else{
        var rpurchaseValue = rtotalValue * CA;
    document.getElementById("r4:0:pt1:it17::content").value = rpurchaseValue;
    document.getElementById("r4:0:pt1:it17::content").readOnly = true;
        }
}

function getValue(val){
    if(document.getElementById("r4:2:pt1:it8::content")!= null && document.getElementById("r4:2:pt1:it9::content") != null &&
    document.getElementById("r4:2:pt1:it10::content")!= null && document.getElementById("r4:2:pt1:it11::content")!= null &&
    document.getElementById("r4:2:pt1:it12::content")!=null && document.getElementById("r4:2:pt1:it13::content")!=null &&
    document.getElementById("r4:2:pt1:it7::content")!=null && document.getElementById("r4:2:pt1:it14::content")!=null &&
    document.getElementById("r4:2:pt1:it15::content")!=null){
    var numVal1=parseInt(document.getElementById("r4:2:pt1:it8::content").value);
    var numVal2=parseInt(document.getElementById("r4:2:pt1:it9::content").value);
    var numVal3=parseInt(document.getElementById("r4:2:pt1:it10::content").value);
    var numVal4=parseInt(document.getElementById("r4:2:pt1:it11::content").value);
    var numVal5=parseInt(document.getElementById("r4:2:pt1:it12::content").value);
    var numVal6=parseInt(document.getElementById("r4:2:pt1:it13::content").value);
    var numValCA=parseInt(document.getElementById("r4:2:pt1:it7::content").value);
    if(isNaN(numValCA)==true){
            numValCA=0;
    }
    if(isNaN(numVal1)==true){
            numVal1=0;
    }
    if(isNaN(numVal2)==true){
            numVal2=0;
    }
    if(isNaN(numVal3)==true){
            numVal3=0;
    }
    if(isNaN(numVal4)==true){
            numVal4=0;
    }
    if(isNaN(numVal5)==true){
            numVal5=0;
    }
    if(isNaN(numVal6)==true){
            numVal6=0;
    }
    var totalValue = numVal1 + numVal2 + numVal3 + numVal4 + numVal5 + numVal6;
    document.getElementById("r4:2:pt1:it14::content").value = totalValue;
    var purchaseValue = totalValue*numValCA;
    document.getElementById("r4:2:pt1:it15::content").value = purchaseValue;
    }
    else
    {
    
    var rnumVal1=parseInt(document.getElementById("r4:0:pt1:it8::content").value);
    var rnumVal2=parseInt(document.getElementById("r4:0:pt1:it9::content").value);
    var rnumVal3=parseInt(document.getElementById("r4:0:pt1:it10::content").value);
    var rnumVal4=parseInt(document.getElementById("r4:0:pt1:it11::content").value);
    var rnumVal5=parseInt(document.getElementById("r4:0:pt1:it12::content").value);
    var rnumVal6=parseInt(document.getElementById("r4:0:pt1:it13::content").value);
    var rnumValCA=parseInt(document.getElementById("r4:0:pt1:it7::content").value);
    if(isNaN(rnumValCA)==true){
            rnumValCA=0;
    }
    if(isNaN(rnumVal1)==true){
            rnumVal1=0;
    }
    if(isNaN(rnumVal2)==true){
            rnumVal2=0;
    }
    if(isNaN(rnumVal3)==true){
            rnumVal3=0;
    }
    if(isNaN(rnumVal4)==true){
            rnumVal4=0;
    }
    if(isNaN(rnumVal5)==true){
            rnumVal5=0;
    }
    if(isNaN(rnumVal6)==true){
            rnumVal6=0;
    }
    var rtotalValue = rnumVal1 + rnumVal2 + rnumVal3 + rnumVal4 + rnumVal5 + rnumVal6;
    document.getElementById("r4:0:pt1:it14::content").value = rtotalValue;
    var rpurchaseValue = rtotalValue*rnumValCA;
    document.getElementById("r4:0:pt1:it15::content").value = rpurchaseValue;
    
    }
}

function onFocus(evnt){
document.getElementById("r4:2:pt1:itSalable::content").readOnly = true;
}
