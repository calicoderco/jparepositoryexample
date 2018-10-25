# -*- mode: ruby -*-
# vi: set ft=ruby :

#
# Change the default virtual machine to be docker
# (In fact docker is the only vm provider supported
#  by this Vagrantfile)
#
ENV['VAGRANT_DEFAULT_PROVIDER'] = 'docker'

def linux?
    return RbConfig::CONFIG['host_os'] =~ /linux/
end

Vagrant.configure("2") do |config|
  # See https://www.vagrantup.com/docs/docker/configuration.html for config options
  config.vm.define "mysql" do |config|
    config.vm.provider "docker" do |d|
      d.name = "jparepositoryexample_mysql"
      d.image = "mysql:5.7"
      d.ports = ["9309:3306"]
      d.env = {
        MYSQL_ROOT_PASSWORD: "root",
        MYSQL_DATABASE:      "jparepositoryexample_db",
        MYSQL_USER:          "practice",
        MYSQL_PASSWORD:      "practice12345"
      }
    end
  end
end