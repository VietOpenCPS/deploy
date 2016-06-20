-----
TESTS
-----

1) Run the test suite on multiple browsers and multiple versions of each
   browser.  Instructions are below.
2) Also, in order to fully test the IframeContainer, run the test suite in the
   following situations:
   a) from a non-standard HTTP port (i.e. mashup.foo.bar.com:8080)
   b) from an HTTPS server


--------------
 INSTRUCTIONS 
--------------

1) Setup Dojo DOH
	a) Download the latest Dojo release from http://dojotoolkit.org -- at least
	   Dojo 1.3 is required.  Get the "src" release, which contains the
	   top-level "util" directory.
	b) Unzip and rename the top level directory to "dojo" (such that there
	   exists the file dojo/dojo/dojo.js).
	c) Move "dojo" to hub20/trunk, so that it is alongside the "testsrc" dir.

2) Setup server & tests
    a) Copy the Hub files to your server.
    b) To fully test the iframe Containers, you should create virtual hosts that
       point to the parent directory of the Hub files you copied in (a).
    c) Update testsrc/config.js with the relevant information.  If you take the
       defaults, then you must set up the following virtual hosts are:
       	    mashup.foo.bar.com
       	    c0.foo.bar.com
       	    c1.foo.bar.com
    
3) Build the release versions
	a) Make sure you have Java and Ant on your system, and that Ant is on your
	   path. 
	b) In a shell or command prompt, go into the 'hub20' directory and enter the
	   command "ant release" to build the release/* directories.

4) Run tests
	a) To run the test suite against the 'src' version of the Hub, 
       load http://mashup.foo.bar.com/hub20/testsrc/test_src.html.
	b) To run the test suite against the release builds of the Hub, 
       load http://mashup.foo.bar.com/hub20/testsrc/test_release.html.
	   (Note: you can test the release/all configuration via
	   test_release_all.html, the release/std configuation via
	   test_release_std.html, and the release/core configuration via the
	   test_release_core.html file.)
	d) To run the test suite against the the 'src' and all release builds of the
	   Hub, load http://mashup.foo.bar.com/hub20/testsrc/test_all.html.
