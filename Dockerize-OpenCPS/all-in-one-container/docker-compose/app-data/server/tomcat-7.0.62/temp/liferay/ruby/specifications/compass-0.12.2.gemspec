# -*- encoding: utf-8 -*-

Gem::Specification.new do |s|
  s.name = %q{compass}
  s.version = "0.12.2"

  s.required_rubygems_version = Gem::Requirement.new(">= 0") if s.respond_to? :required_rubygems_version=
  s.authors = [%q{Chris Eppstein}, %q{Scott Davis}, %q{Eric A. Meyer}, %q{Brandon Mathis}, %q{Anthony Short}, %q{Nico Hagenburger}]
  s.date = %q{2012-06-24}
  s.description = %q{Compass is a Sass-based Stylesheet Framework that streamlines the creation and maintainance of CSS.}
  s.email = %q{chris@eppsteins.net}
  s.executables = [%q{compass}]
  s.files = [%q{bin/compass}]
  s.homepage = %q{http://compass-style.org}
  s.require_paths = [%q{lib}]
  s.rubygems_version = %q{1.8.9}
  s.summary = %q{A Real Stylesheet Framework}

  if s.respond_to? :specification_version then
    s.specification_version = 3

    if Gem::Version.new(Gem::VERSION) >= Gem::Version.new('1.2.0') then
      s.add_runtime_dependency(%q<sass>, ["~> 3.1"])
      s.add_runtime_dependency(%q<chunky_png>, ["~> 1.2"])
      s.add_runtime_dependency(%q<fssm>, [">= 0.2.7"])
    else
      s.add_dependency(%q<sass>, ["~> 3.1"])
      s.add_dependency(%q<chunky_png>, ["~> 1.2"])
      s.add_dependency(%q<fssm>, [">= 0.2.7"])
    end
  else
    s.add_dependency(%q<sass>, ["~> 3.1"])
    s.add_dependency(%q<chunky_png>, ["~> 1.2"])
    s.add_dependency(%q<fssm>, [">= 0.2.7"])
  end
end
