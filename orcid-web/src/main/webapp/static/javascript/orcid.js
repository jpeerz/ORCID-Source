/*
 * =============================================================================
 *
 * ORCID (R) Open Source
 * http://orcid.org
 *
 * Copyright (c) 2012-2014 ORCID, Inc.
 * Licensed under an MIT-Style License (MIT)
 * http://orcid.org/open-source-license
 *
 * This copyright and license information (including a link to the full license)
 * shall be included in its entirety in all copies or substantial portion of
 * the software.
 *
 * =============================================================================
 */
(function($) {
 

    var showingTemplateMenu = false;

    var toolTips = function(){
        $(".settings-button").tooltip({
            placement: "bottom"
        });       
                
        $(".back").tooltip({
            placement: "bottom"
        });
        
        $(".save").tooltip({
            placement: "bottom"
        });
        
        $(".edit").tooltip({
            placement: "bottom"
        });
        
        $(".revoke").tooltip({
            placement: "bottom"
        });
        
        $(".add").tooltip({
            placement: "bottom"
        });
        
        $(".delete").tooltip({
            placement: "bottom"
        });
    };

    var secondaryNavCleanup = function() {
        var items = $(".main > .menu > li.active-trail > ul > li");
        var count = $(items).length;
        var current = $(".main > .menu > li.active-trail").find("li.active-trail a:first").parent().index() + 1;
        if (items) {
            if (current !== count && $(items).children("a").hasClass("active")) {
                $(items[current]).children("a").css({"border-left-color":"#fff"});
            }
            if (current === count) {
                $(items[current-1]).css({"border-right-color" : "#fff"});
            }
        }
    };

    var popupHandler = function() {
        positionPopup();
        $(".template-darken").fadeOut(1);
        $(".template-box").fadeOut(1);
        var closables = $(".close-template-popup, .template-darken");
        $(closables).live("click", function(e) {
            e.preventDefault();
            closePopup();
        });
        $(".open-template-popup").live("click", function(e) {
            e.preventDefault();
            openPopup();
        });
        $(window).resize(function() {
            positionPopup();
        });
    };

    var closePopup = function() {
        $(".template-darken").fadeOut(500);
        $(".template-box").fadeOut(500);

    };

    var openPopup = function() {
        $(".template-popup").show();
        $(".template-darken").fadeIn(500);
        $(".template-box").fadeIn(500);
    };

    var positionPopup = function() {
        var templateBox = $(".template-box");
        var w = $(templateBox).outerWidth();
        var h = $(templateBox).outerHeight();
        var ww = $(window).innerWidth();
        var wh = $(window).innerHeight();
        $(templateBox).css({
            "left": (ww/2) - (w/2) + "px",
            "top": (wh/2) - (h/2) + "px"
        });
    };

    var menuHack = function() {
        $("#signin").on("mouseenter", function(e) {
            $(".header .navigation>.menu").css({"background":"#a6ce39"});        
        });
        $("#signin").on("mouseout", function(e) {
            $(".header .navigation > .menu").css({"background":"#338caf"});
        });
    };
    
    /* Menu Handler Mobile / Desktop - Prototype implementation */
    var menuHandler = function(){
    	
    	var language = $('#language-codes option:selected').text();
        
        var menu = function(menu){
            this.menu = menu;
        };
        
        menu.prototype.data = function(){
            return this.menu;
        };
        	
        
        
        
        
        originalMenu = new menu($('.header .navigation').html()); //Desktop menu data
         
        /* Managing window resizing for restore visibility of some elements due to Javascript actions over the styles for Mobile or Tablet views */
        /*
        $(window).bind('resize', function() {               
            if(navigator.appVersion.indexOf("MSIE 7.") == -1){ //Not IE7                                        
                ww = getWindowWidth();        
                if (ww > 767){ //Tablet ~ PC
                    $(".container .header .search form input[type='search']").blur();
                    
                    $('.header .navigation ul li ul > li.expanded > a').removeClass('slideDown'); //For handling menu animation for third level menus, only on mobile                    
                    
                    
                    restoreDesktopMenu();                                                           
                }else{
                    if(!$(".container .header .search form input[type='search']").is(":focus") && !$('select#language-codes').is(":focus")){ //This is to prevent hiding search and Language selector elements.
                        hideMenuItems(); 
                        restoreMobileMenu(); //Trigger menu adjustment                        
                    }
                    $('.header .navigation ul li ul > li.expanded > a').addClass('slideDown'); //For handling menu animation for third level menus, only on mobile                    
                }
                        
            }
        });
		    
        */
        
        var restoreDesktopMenu = function(){
                // Restoring different elements of the Desktop layout, this is due the menu modification performed to adapt it to mobile devices                
                if($('#mobile-menu-icon').css('display') == 'none'){
                    $('.container .header .search').css('display', 'block');
                    $('.container .header .search #form-search').css('display', 'block');
                    $('.container .header .search #languageCtrl').css('display', 'block');
                    $('.header .navigation > .menu').css('display', 'block');

                    
                    $('.header .navigation > .menu > li > .menu').css('display', 'block');

          
                    $('.header .navigation').html(''); //Deleting DOM content
                    $('.header .navigation').prepend(originalMenu.data());                    
                }
        };
    
        var prepareMobileMenu = function(){
            var topItems = $('.header .navigation > .menu > li > a');
            var topItemsLi = $('.header .navigation > .menu > li');
            $('.header .navigation > .menu > li.last.leaf').hide();
            

            var links = $('.header .navigation > .menu > li > .menu > li').has('ul').children('a');
            var toInject = $('.header .navigation > .menu > li > .menu > li > ul.menu');                           
           
            //Inject links to the Second Level
            for( var i = 0; i < topItems.length; ++i){                                
                $(topItemsLi[i]).children().not("a").prepend('<li class="first"><a href="'+topItems[i].href+'">'+topItems[i].text+'</li>');                    
            }

            for (var i = 0; i < links.length; ++i){
                $(toInject[i]).prepend('<li class="leaf"><a href="'+links[i].href+'">'+links[i].text+'</li>');                   
            }

            $('.header > .row > .navigation > .menu > li > a:not(:last-child)').not("ul li ul li a").removeAttr('href');

            //Removing links for elements with three level menus.
            $('.header .navigation > .menu > li > .menu > li').has('ul').children('a').attr('href', '');            
            
            //$('.header .navigation ul li ul > li').not('li.expanded').addClass('blank');

            $('.header .navigation ul li ul > li.expanded > a').addClass('slideDown'); //For handling menu animation for third level menus, only on mobile
            //$('.header .navigation ul li ul > li.expanded > a.slideDown').addClass("glyphicon x0 glyphicon-plus-after");
            $('.header .navigation ul li ul > li.expanded > a.slideDown').append(' (+)');
            
            mobileMenu = new menu($('.header .navigation').html()); //Menu data            
            restoreDesktopMenu(); //Restoring original menu after changes
            
        };        
        
        prepareMobileMenu();
        
        
        var restoreMobileMenu = function(){
            $('.header .navigation').html(''); //Deleting DOM menu content
            $('.header .navigation').prepend(mobileMenu.data()); //Restoring mobile menu structure

            
            $('.header .navigation > .menu > li > a').live('click', function(event){
                $('.header .navigation > .menu > li').removeClass('active-trail');
            });
        };
        
        $('.header .navigation ul li ul li a.slideDown').live('click', function(event){ //For handling menu animation for third level menus, only on mobile
            event.preventDefault();            
            var hasChildren = $(this).parent().has('ul').length;
            if(hasChildren){
                var display = $(this).parent().children('ul').css('display');
                if (display == 'none'){                                        
                    $(this).parent().children('ul').slideDown('slow');
                    var text = $(this).html();
                    text = text.replace(' (+)', ' (-)');
                    $(this).html(text);
                }else{
                    $(this).parent().children('ul').slideUp('slow');
                    var text = $(this).html();
                    text = text.replace(' (-)', ' (+)');
                    $(this).html(text);
                }
            }else{
                 window.location = this.href;                
            }
        });        
        
        
        $('#mobile-menu-icon').live('click', function(event){           
            event.preventDefault();
            tap('.container .header .navigation > .menu', this);            
        });        

        /* Search */ 
        $('#mobile-search').live('click', function(event){          
            event.preventDefault();            
            tap('.container .header #form-search', this);            
        });

        /* Settings */
        $('#mobile-settings').live('click', function(event){
           event.preventDefault();
           tap('.container .header #languageCtrl', this);           
        });

        var tap = function(menuObject, menuButton){            
            var display = $(menuObject).css('display');            
            if(display == 'none'){
                //ideMenuItems(menuObject);
                if($(menuButton).attr('id') == 'mobile-search' || $(menuButton).attr('id') == 'mobile-settings'){
                    $('.container .header #search').css('display', 'block');
                }
                $(menuObject).css('display','block');
                $(menuButton).css('background','#939598');
            }else{              
                if($(menuButton).attr('id') == 'mobile-search' || $(menuButton).attr('id') == 'mobile-settings'){
                    $('.container .header #search').css('display', 'none');
                }
                $(menuObject).css('display','none');
                $(menuButton).css('background','#338CAF');                 
            }
        };
        
        /*

        var hideMenuItems = function(menuObject){
            if($(menuObject).hasClass('menu')){ 
                $('.container .header #search').css('display', 'none');                                                
                $('.container .header #form-search').css('display', 'none');
                $('.header .navigation > #mobile-search').css('background', '#338CAF');
                $('.header .navigation > #mobile-settings').css('background','#338CAF');                
            }            
            
            if($(menuObject).attr('id') == 'form-search'){             
                $('.header .navigation > .menu').css('display', 'none');            
                $('#mobile-menu-icon').css('background', '#338CAF');
                $('.header .navigation > #mobile-settings').css('background', '#338CAF');
                $('#languageCtrl').css('display', 'none');
            
            }

            if($(menuObject).attr('id') == 'languageCtrl'){            
                $('.header .navigation > .menu').css('display', 'none');
                $('.container .header #search').css('display', 'none'); 
                $('.container .header #form-search').css('display', 'none');
                $('#mobile-menu-icon').css('background', '#338CAF');
                $('#mobile-search').css('background', '#338CAF');
            
            }
            
            if(typeof menuObject == 'undefined'){
            
                $('.header .navigation > .menu').css('display', 'none');            
                $('.container .header #search').css('display', 'none');                
                $('.container .header .search #languageCtrl').css('display', 'none');
            
                $('.header .navigation > .mobile-menu-icon').css('background','#338CAF');
                $('.header .navigation > .mobile-search').css('background','#338CAF');
                $('.header .navigation > .mobile-settings').css('background','#338CAF');                            
            } 
            
        };
        */
    };    
	
   
    /*============================================================
        Page initialisation
    ============================================================*/

    var init = function() {
        toolTips();
        popupHandler();
        //menuHack();        
        menuHandler();
    };

    
    
    init();

})(jQuery);