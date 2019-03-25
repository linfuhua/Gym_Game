$.fn.pageBar = function(options) {
    var configs = {
        PageIndex: 1,
        TotalPage: 0,
        showPageCount: 4,
        onPageClick: function(pageIndex) {
            return false;   //榛樿鐨勭炕椤典簨浠�
        }
    };
    $.extend(configs, options);
    var tmp = "",
        i = 0,
        j = 0,
        a = 0,
        b = 0,
        totalpage=configs.TotalPage;
    if (configs.PageIndex > 1) {
        tmp += "<a>涓婁竴椤�/a>";
    } else {
        tmp += "<a class=\"no\">涓婁竴椤�/a>";
    }
    tmp += "<a>1</a>";
    //鍔ㄦ�鐢熸垚
    if (totalpage > configs.showPageCount + 1) {
        //灏忎簬5
        if (configs.PageIndex <= configs.showPageCount) {
            i = 2;
            j = i + configs.showPageCount;
            a = 1;
        } else if (configs.PageIndex > totalpage - configs.showPageCount) {//澶т簬96
            i = totalpage - configs.showPageCount;
            j = totalpage;
            b = 1;
        } else {//5~96涔嬮棿
            var k = parseInt((configs.showPageCount - 1) / 2);
            i = configs.PageIndex - k;
            j = configs.PageIndex + k + 1;
            a = 1;
            b = 1;
            if ((configs.showPageCount - 1) % 2) {
                i -= 1;
            }
        }
    }
    else {
        i = 2;
        j = totalpage;
    }
    if (b) {
        tmp += "...";
    }
    for (; i < j; i++) {
        tmp += "<a>" + i + "</a>";
    }
    if (a) {
        tmp += " ... ";
    }
    if (totalpage > 1) {
        tmp += "<a>" + totalpage + "</a>";
    }
    if (configs.PageIndex < totalpage) {
        tmp += "<a>涓嬩竴椤�/a>";
    } else {
        tmp += "<a class=\"no\">涓嬩竴椤�/a>";
    }

    tmp += "<input type=\"text\" /><a>Go</a>";

    //鎶妕mp鍔犺浇鍒伴〉闈�
    var pager = this.html(tmp);

    //涓烘瘡涓猘鏍囩缁戝畾浜嬩欢
    var index = pager.children('input')[0];
    pager.children('a').click(function() {
       // var This=$(this);
        var cls = $(this).attr('class');
        if (this.innerHTML == 'pre') {
            if (cls != 'no') {
                configs.onPageClick(configs.PageIndex - 2);
              ///  $(this).css('background','#0F71BE');
            }
        } else if (this.innerHTML == 'next') {
            if (cls != 'no') {
                configs.onPageClick(configs.PageIndex);
                $(this).css('background','#0F71BE');
            }
        } else if (this.innerHTML == 'Go') {
            if (!isNaN(index.value)) {
                var indexvalue = parseInt(index.value);
                indexvalue = indexvalue < 1 ? 1 : indexvalue;
                indexvalue = indexvalue > totalpage ? totalpage : indexvalue;
                configs.onPageClick(indexvalue - 1);
                $(this).css('background','#0F71BE');
            }
        } else {
            if (cls != 'cur') {
                configs.onPageClick(parseInt(this.innerHTML) - 1);
            }
        }
    }).each(function() {
        if (configs.PageIndex == parseInt(this.innerHTML)) {
            $(this).addClass('cur');
        }
    });
}